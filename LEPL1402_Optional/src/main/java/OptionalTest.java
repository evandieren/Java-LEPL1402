import java.util.Optional;
import java.util.function.Function;

public class OptionalTest {

    /**
     * Returns an Optional<TeamLeader> object from teamLeader
     */
    public Optional<TeamLeader> createOptionalTeamLeader(TeamLeader teamLeader) {
        return Optional.ofNullable(teamLeader);
    }

    /**
     * Increments the age of teamLeader by one
     */
    public void incAge(Optional<TeamLeader> optionalTeamLeader) {
        optionalTeamLeader.ifPresent(teamLeader -> teamLeader.setAge(teamLeader.getAge() + 1));
    }

    /**
     * Increments the age of teamLeader by one only if its age is > 15
     */
    public void incAgeIfMoreThanFifteen(Optional<TeamLeader> optionalTeamLeader) {
        optionalTeamLeader.ifPresent(teamLeader -> {if (teamLeader.getAge()>15){incAge(optionalTeamLeader);}});
    }

    /**
     * Returns the name of the teamLeader or "No team leader"
     */
    public String getName(Optional<TeamLeader> optionalTeamLeader) {
        return optionalTeamLeader.map(TeamLeader::getName).orElse("No team leader");
    }

    /**
     * Returns the name of the teamLeader of the team of the person or "No team leader"
     */
    public String getNameOfTeamLeader(Optional<Person> optionalPerson) {
        return optionalPerson.flatMap(person -> person.getTeam().flatMap(team -> team.getTeamLeader().map(TeamLeader::getName))).orElse("No team leader");
    }
}

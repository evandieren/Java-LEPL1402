import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StudentFunctions implements StudentStreamFunction {

  StudentFunctions(){ }

  public static void main(String[] args) {

    Map<String, Double> resultatEliott = new HashMap();
    resultatEliott.put("Analyse", 19.0);
    resultatEliott.put("MethodeNum", 1.0);
    resultatEliott.put("Algebre", 1.0);

    Map<String, Double> resultatEmma = new HashMap();
    resultatEmma.put("Analyse", 16.0);
    resultatEmma.put("MethodeNum", 19.0);

    Map<String, Double> resultatAugustin = new HashMap();
    resultatAugustin.put("Analyse", 11.0);
    resultatAugustin.put("MethodeNum", 11.0);


    Stream<Student> stream = Stream.of(new Student("Eliott","Van Dieren",4,resultatEliott),
                                       new Student("Emma","Stiennon",4,resultatEmma),
                                       new Student("Augustin","Vercoutere",4,resultatAugustin));

    Stream<Student> result = new StudentFunctions().findSecondAndThirdTopStudentForGivenCourse(stream,"Analyse");
    result.forEach((student -> System.out.println(student.getFirstName())));
  }

  public Stream<Student> findSecondAndThirdTopStudentForGivenCourse(Stream<Student> studentStream, String name){

    // Meth 1
    Student[] sorted = studentStream.sorted((s1,s2) -> Double.compare(s1.getCoursesResults().get(name),s2.getCoursesResults().get(name))).toArray(Student[]::new);
    return Stream.of(sorted[sorted.length-2],sorted[sorted.length-3]);
    // Meth 2
//    Student[] sorted = studentStream
//            .filter(student -> student.getCoursesResults().containsKey(name))
//            .sorted(Comparator.comparing((Student student) -> student.getCoursesResults().get(name)).reversed())
//            .toArray(Student[]::new);
//    return Stream.of(sorted[1],sorted[2]);


//    Object[] sorted = studentStream.sorted(new Comparator<Student>() {
//      @Override
//      public int compare(Student o1, Student o2) {
//        return (int) (o2.getCoursesResults().get(name) - o1.getCoursesResults().get(name));
//      }
//    }).toArray();
//
//    return Stream.of((Student) sorted[1], (Student) sorted[2]);
  }

  public Object[] computeAverageForStudentInSection(Stream<Student> studentStream, int section){
    return studentStream.filter((std) -> std.getSection() == section).sorted(Comparator.naturalOrder()).map((std) -> new Object[]{
      String.format("Student %s %s",std.getFirstName(),std.getLastName(),
              std.getCoursesResults().values().stream().reduce(0.0,Double::sum)/std.getCoursesResults().values().size())
      }).toArray();
  }

  public int getNumberOfSuccessfulStudents(Stream<Student> studentStream){
    return (int) studentStream
            .filter((std) -> {
              Stream<Double> success = std.getCoursesResults().values().stream().filter((n) -> n > 10);
              return success.count() == std.getCoursesResults().size();})
            .count();
  }

  public Student findLastInLexicographicOrder(Stream<Student> studentStream){
    Student[] sorted = studentStream.sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName)).toArray(Student[]::new);
    return sorted[sorted.length - 1];
  }

  public double getFullSum(Stream<Student> studentStream){
    return studentStream.map(((student) -> student.getCoursesResults().values().stream().reduce(0.0,Double::sum))).reduce(0.0,Double::sum);
  }
}


public class Pair<String, Integer> {

    private String alert;
    private Integer zone;

    public Pair(String alert, Integer zone){
        this.alert = alert;
        this.zone = zone;
    }

    public Integer getZone() {
        return zone;
    }

    public String getAlert() {
        return alert;
    }

    @Override
    public boolean equals(Object o){
        Pair<String,Integer> other = (Pair<String, Integer>) o;
        return this.alert == other.alert && this.zone == other.zone;
    }

}

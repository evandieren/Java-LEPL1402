public class Client extends Observer{

    public Client(int zone){
        this.zone = zone;
        this.news = "";
    }

    @Override
    public void update(Object o) {
        this.news = (String) o;
    }

    @Override
    public int getZone() {
        return this.zone;
    }

    @Override
    public String getNews() {
        return this.news;
    }
}

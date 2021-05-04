public class WeatherStation extends Observable {

    @Override
    public Observer[] getSubscribers() {
        Observer[] result = new Observer[this.subscribers.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = this.subscribers.get(i);
        }
        return result;
    }

    @Override
    public void broadcast(Pair<String, Integer> pair) {
        for (int i = 0; i < this.subscribers.size(); i++) {
            if (this.getSubscribers()[i].getZone() == pair.getZone()){
                this.getSubscribers()[i].update(pair.getAlert());
            }
        }
    }

    @Override
    public void addObserver(Observer sub) {
        this.subscribers.add(sub);
    }

    @Override
    public boolean removeObserver(Observer sub) {
        return this.subscribers.remove(sub);
    }

    @Override
    public void setAlert(String alert, int zone) {
        this.broadcast(new Pair(alert, zone));
    }
}

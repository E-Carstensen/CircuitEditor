public interface Subject {

    void addObserver(Observer o );
    void removeObserver(Observer o);

    void notifyObservers();

    boolean getOutput();

    void setName(String name);
    String getName();
}

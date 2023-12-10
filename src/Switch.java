import java.util.ArrayList;
import java.util.List;

public class Switch implements Subject{

    protected boolean state;
    protected String name;
    private List<Observer> observers = new ArrayList<>();

    public void setState(boolean newState){
        this.state = newState;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers){
            observer.update();
        }
    }

    @Override
    public boolean getOutput() {
        return state;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

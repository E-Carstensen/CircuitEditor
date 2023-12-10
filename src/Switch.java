import java.util.ArrayList;
import java.util.List;

/**
 * Switch implementation of Subject
 * Has a defined input that can be set, and no inputs
 * Can have any number of Observers
 * Default output is false
 */
public class Switch implements Subject{

    protected boolean state = false;
    protected String name;
    private List<Observer> observers = new ArrayList<>();

    /**
     * Allows changing of output, notifies all observers
     * @param newState boolean new state of switch
     */
    public void setState(boolean newState){
        this.state = newState;
        notifyObservers();
    }

    /**
     * Adds new Observer to list of Observers, will be notified of changes to output
     * @param o Observer object to be added to list
     */
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Removes Observer from observers list, will no longer be notified of changes
     * Ensures given Observer is in the list first
     * @param o Observer object to remove from observers list
     */
    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {observers.remove(o);}
    }

    /**
     * Iterates over every Observer in observers and tells it to check its inputs
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers){
            observer.update();
        }
    }

    /**
     * Helper method for retrieving current state of the gate
     * @return boolean current this.state
     */
    @Override
    public boolean getOutput() {
        return state;
    }

    /**
     * Allows for a String name representing this gate
     * @param name String to set this.name to
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves current name of this gate
     * @return String this.name
     */
    @Override
    public String getName() {
        return name;
    }
}

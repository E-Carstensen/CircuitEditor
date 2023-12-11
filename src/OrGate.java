import java.util.ArrayList;
import java.util.List;

/**
 * Or gate implementation of Observer & Subject
 * Takes any number of inputs and if any are true outputs true, false otherwise
 * No input state is true
 */
public class OrGate implements Observer, Subject{

    private List<Observer> observers = new ArrayList<>();
    private List<Subject> inputs = new ArrayList<>();

    protected String name;
    protected boolean output;

    /**
     * Iterates over every Subject within inputs
     * If any of the subjects outputs are true, return true, false otherwise
     * if inputs is empty, output true
     * Calls notifyObservers to tell all Observers observing this Subject to check their inputs
     */
    @Override
    public void update() {

        if (inputs.isEmpty()){
            output = true;
            notifyObservers();
            return;
        }

        for (Subject input : inputs){
            if (input.getOutput()){
                output = true;
                notifyObservers();
                return;
            }
        }
        output = false;
        notifyObservers();
    }

    /**
     * Retrieves current name of this gate
     * @return String this.name
     */
    @Override
    public String getName() {
        return name;
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
     * Adds a Subject to the List of inputs
     * Will add itself to Subjects list of observers
     * @param input Subject add as an input
     */
    @Override
    public void addInput(Subject input) {
        inputs.add(input);
        input.addObserver(this);
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
        for (Observer o : observers){
            o.update();
        }
    }
    /**
     * Helper method for retrieving current state of the gate
     * @return boolean current this.state
     */
    @Override
    public boolean getOutput() {
        return output;
    }
}

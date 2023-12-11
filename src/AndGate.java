import java.util.ArrayList;
import java.util.List;

/**
 * And gate implementation of Observer & Subject
 * Takes any number of input Subjects and outputs true only when all inputs are true
 * Defaults to false when no inputs
 */
public class AndGate implements Observer, Subject{

    private List<Subject> inputs = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    protected boolean output = false;
    protected String name;

    /**
     * Iterates over input Subjects and checks their state
     * If all inputs are true, output true, output false otherwise
     * If inputs is empty, output false
     */
    @Override
    public void update() {

        if (inputs.isEmpty()){
            output = false;
            notifyObservers();
            return;
        }

        for (Subject input : inputs){
            if (!input.getOutput()){
                output = false;
                notifyObservers();
                return;
            }
        }
        output = true;
        notifyObservers();
    }

    /**
     * Adds new observer to list of Observers, will be notified of changes to outputs
     * @param o new Observer obj to add to list
     */
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Removes Observer from observers list, will no longer be notified of changes in this Subjects output
     * Ensures given Observer is in the list first
     * @param o Observer object to remove from observers list
     */
    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {observers.remove(o);}
    }
    /**
     * Iterates over all Observers in observer list and tells it to check its inputs and update
     */
    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.update();
        }
    }
    /**
     * Helper method returns current output
     * @return boolean current state of gate
     */
    @Override
    public boolean getOutput() {
        return output;
    }

    /**
     * Helper method returns current gate name
     * @return String this.name
     */
    public String getName(){
        return name;
    }
    /**
     * Allows String representation of a gate
     * Sets this.name to given string
     * @param name String to set this.name to
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Adds new subject to list of inputs
     * Adds this gate to Subjects list of observers
     * @param input Subject to observer
     */
    @Override
    public void addInput(Subject input) {
        inputs.add(input);
        input.addObserver(this);
    }
}

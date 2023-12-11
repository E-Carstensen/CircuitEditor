import java.util.ArrayList;

/**
 * Not gate implementation of Subject & Observer
 * Takes a single input and inverts it as its output
 * Default state is true
 */
public class NotGate implements Subject, Observer{

    private Subject input = null;

    protected boolean output = true;

    private ArrayList<Observer> observers = new ArrayList<>();

    protected String name;

    /**
     * Checks state of current input, sets output accordingly, and notifies all observers
     * If Subject = null, no input, default true
     * Else invert input
     */
    @Override
    public void update() {
        // if no input output true
        if (input == null){
            output = true;
            notifyObservers();
            return;
        }

        // output the opposite of the input
        if (input.getOutput()) {
            output = false;
        } else {
            output = true;
        }
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
        if (i >= 0) {
            observers.remove(o);
        }
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
     * Allows String representation of a gate
     * Sets this.name to given string
     * @param name String to set this.name to
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets current input to new Subject
     * Adds this gate to Subjects list of observers
     * @param input Subject to observer
     */
    @Override
    public void addInput(Subject input) {
        this.input = input;
        input.addObserver(this);
    }

    /**
     * Helper method returns current gate name
     * @return String this.name
     */
    @Override
    public String getName() {
        return name;
    }
}

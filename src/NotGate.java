import java.util.ArrayList;

/**
 * Not gate implementation of Subject & Observer
 * Takes a single input and inverts it as its output
 * Default state is true
 */
public class NotGate implements Subject, Observer{

    private Subject input;

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
        if (input == null){
            output = true;
            notifyObservers();
            return;
        }

        if (input.getOutput()){
            output = false;
        }else{
            output = true;
        }
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
        for (Observer o : observers){
            o.update();
        }
    }

    @Override
    public boolean getOutput() {
        return output;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets current input to new Subject
     * @param input Subject to observer
     */
    @Override
    public void addInput(Subject input) {
        this.input = input;
        input.addObserver(this);
    }

    @Override
    public String getName() {
        return name;
    }
}

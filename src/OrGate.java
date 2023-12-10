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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addInput(Subject input) {
        inputs.add(input);
        input.addObserver(this);
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
}

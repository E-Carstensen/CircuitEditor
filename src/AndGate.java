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

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {observers.remove(o);}
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

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public void addInput(Subject input) {
        inputs.add(input);
        input.addObserver(this);
    }
}

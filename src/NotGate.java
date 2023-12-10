import java.util.ArrayList;

public class NotGate implements Subject, Observer{

    private Subject input;

    protected boolean output;

    private ArrayList<Observer> observers = new ArrayList<>();

    protected String name;

    @Override
    public void update() {
        output = !input.getOutput();
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

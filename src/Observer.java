public interface Observer {

    void update();

    String getName();

    void setName(String name);

    void addInput(Subject input);
}

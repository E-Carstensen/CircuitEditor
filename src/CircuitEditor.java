public class CircuitEditor {

    public static void CircuitEditorDemo(){

        // Initialize some switches
        Switch switch1 = new Switch();
        Switch switch2 = new Switch();

        switch1.setName("On");
        switch1.setState(true);

        switch2.setName("Off For Now");
        switch2.setState(false);

        Switch switch3 = new Switch();
        switch3.setState(false);
        switch3.setName("Always Off");


        // One true one false, should output false
        AndGate andGate = new AndGate();
        andGate.addInput(switch1);
        andGate.addInput(switch2);

        // Two false inputs should output false
        OrGate orGate = new OrGate();
        orGate.addInput(andGate);
        orGate.addInput(switch3);

        // One false input should output false
        NotGate notGate = new NotGate();
        notGate.addInput(orGate);


        printDemoCircuit( switch1, switch2, andGate,orGate, switch3, notGate);

        // Display values for all gates


        System.out.println("\nFlipping Switch 2\n");
        // Change switch state to change all gate states
        switch2.setState(true);

        // Display values for all gates

        printDemoCircuit( switch1, switch2, andGate,orGate, switch3, notGate);



    }


    private static void printDemoCircuit(Switch s1, Switch s2, AndGate ag, OrGate og, Switch s3, NotGate ng){
        System.out.printf("Switch 1:  [%b]\n" +
                        "      |\n" +
                        "      |-AND Gate [%b]-| \n" +
                        "      |                | \n" +
                        "Switch 2: [%b]       |\n" +
                        "                       |\n" +
                        "                       |---OR Gate [%b]---| \n" +
                        "                       |                    |\n" +
                        " Switch 3 [%b] -----|                    |\n" +
                        "                                            |---NOT Gate---[%b]\n%n", s1.getOutput(),
                s2.getOutput(), ag.getOutput(),og.getOutput(), s3.getOutput(), ng.getOutput());

        System.out.println("AND Gate Output (should be false): " + ag.getOutput());
        System.out.println("OR Gate Output (should be false): " + og.getOutput());
        System.out.println("NOT Gate Output (should be true): " + ng.getOutput());


    }

}

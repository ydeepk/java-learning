package basics.variableScope;

public class AllVariableScope {

    private int instanceVar = 10; // instance variable, belongs to each object

    static int day = 26; // static variable, shared across all the instances

    // constructor demonstrating parameter scope
    public AllVariableScope(int instanceVar) {
        // parameter scope
        // using 'this' to refer to the instance variable
        this.instanceVar = instanceVar;
    }

    // method to demonstrate local, parameter and block scope variable
    public void displayAge(int paramVar) {

        // local variable only accessible in this method
        int localVariable = 20;

        System.out.println("Instance variable"+instanceVar);
        System.out.println("Static variable"+day);
        System.out.println("Method parameter"+paramVar);
        System.out.println("local variable"+localVariable);

        // Block scope, only accessible within this scope
        if(paramVar < 26) {
            int blockVar = 5;
            System.out.println("Block Variable"+blockVar);
        }

        // out of scope -> block variable, uncommenting below line would cause an error
        //System.out.println("Block variable"+blockVar);
    }

    public static void main(String[] args) {
        AllVariableScope avs = new AllVariableScope(2);
        avs.displayAge(21);
    }

}

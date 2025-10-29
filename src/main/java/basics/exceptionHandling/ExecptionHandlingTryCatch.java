// https://www.geeksforgeeks.org/java/exceptions-in-java/

package basics.exceptionHandling;

public class ExecptionHandlingTryCatch {

    public static void main(String[] arg) {

        int[] num1 = {0,1,2,3};

        try {
            System.out.println("This is 'try' block and the value is "+num1[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught message "+ e.getMessage() + "\nactual thrown "+e);
        }
        finally {
            System.out.println("Finally executed !");
        }

    }

}

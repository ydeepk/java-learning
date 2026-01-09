package basics.recursion;

/**
 * Demonstrates printing numbers from 1 to n using recursion.
 */
public class PrintNumbersRecursively {

    public static void main(String[] args) {
        printNumbers(6);
    }

    /**
     * Prints numbers from 1 to n using recursion.
     *
     * @param n the maximum number to print
     */
    private static void printNumbers(int n) {
        // Base case: stop recursion when n reaches 0
        if (n == 0) {
            return;
        }

        // Recursive call with smaller problem
        printNumbers(n - 1);

        // Print during the unwinding phase
        System.out.println(n);
    }
}
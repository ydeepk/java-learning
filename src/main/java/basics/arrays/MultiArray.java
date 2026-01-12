package basics.arrays;

public class MultiArray {

    // Method to print a specific value from a 2D (two-dimensional) array
    public static void get2DArrayValue(int x, int y) {

        // Declare and initialize a 2D integer array
        // The first row has 3 elements, the second row has 2 elements
        int[][] twoDArray = {
                {5, 6, 7},
                {8, 9}
        };

        // Print the element at the specified row (x) and column (y)
        System.out.println(twoDArray[x][y]);
    }

    /*
     * Explanation:
     * ------------------------------
     * A 2D array is an array of arrays.
     *
     * Example visualization:
     *
     *   Index reference:
     *        Column →   0   1   2
     *        Row ↓
     *          0       [5] [6] [7]
     *          1       [8] [9]
     *
     * So:
     *   twoDArray[0][1] → 6
     *   twoDArray[1][0] → 8
     *
     * A 3D array extends this concept with one more dimension
     * (an array containing multiple 2D arrays).
     */

    // Main method — entry point of the program
    public static void main(String[] args) {

        // Access and print the element at row index 1 and column index 1 (value: 9)
        get2DArrayValue(1, 1);
    }
}

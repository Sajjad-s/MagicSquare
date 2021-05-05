import static org.junit.Assert.assertArrayEquals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        System.out.println("Enter the 3x3 Matrix");
        int[][] array = main.getInputArray();
        showArray(array);
        int  result = main.findMinimum(array);
        System.out.println("The answer is: " + result);

    }

    private static void showArray(int[][] array) {
        int counter = 0;
        System.out.println("Your input matrix is: ");
        try {
            String str = "|\t";
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    str += array[i][j] + "\t";
                    counter++;
                }
                System.out.println(str + "|");
                str = "|\t";
            }
        } catch (Exception e) {
            System.out.println("Matrix is empty!!");
        }
    }

    public int[][] getInputArray() {
        int[][] inputArray = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("\n");
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter the [" + i + "] [" + j + "]: ");
                inputArray[i][j] = scanner.nextInt();
            }
        }
        return inputArray;
    }

    public static int findMinimumFromMagicSquare(int[][] array,
                                                 int[][] magicSquare) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] != magicSquare[i][j])
                    count++;
            }
        }
        return count;
    }

    public static int findMinimum(int[][] array) {
        int[][][] magicSquare = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
        };

        // If all the elements need to be changed,
        // there would be 9 changes, so we take the
        // max as 9
        int min = 9;
        for (int i = 0; i < 8; i++) {
            int x = findMinimumFromMagicSquare(array, magicSquare[i]);
            if (x < min)
                min = x;
        }
        return min;
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        System.out.println("Enter the 3x3 Matrix");
        int[] array = main.getInputArray();
        showArray(array);
        main.checkSquare(array);

    }

    private static void showArray(int[] array) {
        int counter = 0;
        System.out.println("Your input matrix is: ");
        try {
            String str = "|\t";
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    str += array[counter] + "\t";
                    counter++;
                }
                System.out.println(str + "|");
                str = "|\t";
            }

        } catch (Exception e) {
            System.out.println("Matrix is empty!!");
        }
    }

    public int[] getInputArray() {
        int[] inputArray = new int[9];
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("\n");
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter the [" + i + "] [" + j + "]: ");
                inputArray[counter] = scanner.nextInt();
                counter++;
            }
        }
        return inputArray;
    }

    public int checkSquare(int[] inputArray) {
        int[][] baseArrays = {
                {8, 1, 6,
                 3, 5, 7,
                 4, 9, 2},

                {6, 1, 8,
                 7, 5, 3,
                 2, 9, 4},

                {4, 9, 2,
                 3, 5, 7,
                 8, 1, 6},

                {2, 9, 4,
                 7, 5, 3,
                 6, 1, 8},

                {8, 3, 4,
                 1, 5, 9,
                 6, 7, 2},

                {4, 3, 8,
                 9, 5, 1,
                 2, 7, 6},

                {6, 7, 2,
                 1, 5, 9,
                 8, 3, 4},

                {2, 7, 6,
                 9, 5, 1,
                 4, 3, 8}


        };
        int best = 10000;
        for (int i = 0; i < 8; i++) {
            int difference = 0;
            for (int j = 0; j < 9; j++) {
                difference += Math.abs( inputArray[j] - baseArrays[i][j]);
                if (difference < best) best = difference;
            }

        }
        System.out.println("The Answer is: " + best);


        return 0;
    }
}

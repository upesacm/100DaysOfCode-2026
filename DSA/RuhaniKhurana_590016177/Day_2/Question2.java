import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int[] array = new int[r];

        for (int i = 0; i < r; i++) {
            array[i] = sc.nextInt();
        }

        int large = array[0];

        for (int i = 1; i < r; i++) {
            if (array[i] > large) {
                large = array[i];
            }
        }

        System.out.println(large);

        sc.close();
    }
}
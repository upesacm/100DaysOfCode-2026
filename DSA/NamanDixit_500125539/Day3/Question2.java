import java.util.Scanner;
public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Enter Target value: ");
        int target = scanner.nextInt();

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == target) {
                count++;
            }
        }
        System.out.println("Number of occurrences of " + target + ": " + count);
    }
    
}

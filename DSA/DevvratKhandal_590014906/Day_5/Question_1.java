import java.util.Scanner;

public class Question_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int maxReach = 0;

        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                System.out.println(false);
                return;
            }

            maxReach = Math.max(maxReach, i + nums[i]);
        }

        System.out.println(true);
    }
}
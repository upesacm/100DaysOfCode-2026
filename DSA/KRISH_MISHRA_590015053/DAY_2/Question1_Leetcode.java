import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int val = sc.nextInt();

        int k = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        System.out.println(k);

        for(int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }
}

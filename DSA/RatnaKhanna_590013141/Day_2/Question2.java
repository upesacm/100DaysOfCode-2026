import java.util.*;
public class Question2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        arr[0] = sc.nextInt();
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
        sc.close();
    }
}

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int a = sc.nextInt();
        int arr[] = new int[a];
        int sum = 0;
        System.out.println("Enter array elements");
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
            sum = sum + arr[i];
        }
        System.out.println("The sum of the array is " + sum);

        sc.close();
    }
}
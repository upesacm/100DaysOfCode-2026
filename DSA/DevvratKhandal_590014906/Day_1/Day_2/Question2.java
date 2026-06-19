import java.util.Scanner;
//CODE to find the largest element in an array
public class Question2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of array: \n");
        int n = sc.nextInt(); // Size of array
        int[] arr = new int[n];
        

        // Input array elements
        System.out.println("Elemnts in the array: \n");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        

        int largest = arr[0];

        // Find largest element

        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        System.out.println("Largest element in the given array is:"+largest);

        sc.close();
    }
}
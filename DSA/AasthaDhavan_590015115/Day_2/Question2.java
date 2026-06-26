import java.util.Scanner;

public class Question2 {
    public int maxim(int[] arr, int n) {
        int max = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        Question2 obj = new Question2();
        int max = obj.maxim(arr, n);
        System.out.println("Maximum element in the array is: " + max);
    }
}

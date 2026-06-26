import java.util.Scanner;

public class d2q1 {
    public static void main(String[] args) {
        int n;
        int largest;

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        n = s.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter the elements of the array: ");

        for(int i =0 ;i<n; i++){
            arr[i] = s.nextInt();
        }

        largest = arr[0];

        for(int i =0; i<n; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }

        System.out.println("The largest number is: " + largest);
    }
}

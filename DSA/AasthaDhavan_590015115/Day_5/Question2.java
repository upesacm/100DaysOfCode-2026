import java.util.Scanner;
import java.util.Arrays;

public class Question2 {
    public boolean check(int arr1[],int arr2[]){
        if(arr1.length!=arr2.length){
            return false;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        System.out.print("Enter array elements for arr1: ");
        for(int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
        }
        int[] arr2 = new int[n];
        System.out.print("Enter array elements for arr2: ");
        for(int i=0; i<n; i++){
            arr2[i] = sc.nextInt();
        }
        Question2 q = new Question2();
        System.out.println(q.check(arr1, arr2));
    }
}
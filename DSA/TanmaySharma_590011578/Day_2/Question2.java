package DSA.TanmaySharma_590011578.Day_2;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Length of the Array: ");
        int n= in.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();

        }
        Question2 obj = new Question2();
        System.out.println(obj.largest(arr));
    }
    public int largest(int[] arr ){
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            if(i>max){
                max=i;
            }

        }
        return max;
    }
}

package Day_4;

import java.util.Arrays;
import java.util.Scanner;

public class Question2 {
    public static void reverse(int arr[],int a,int b){
        int n=arr.length;
        while(a<=b){
            int temp=arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
            a++;
            b--;

        }
    }
    public static void rotateByk(int arr[], int k){
        int n=arr.length;
        if(k>=n){
            k=k%n;
        }
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr={-1,-100,3,99};
        int k=2;
        rotateByk(arr,k);
        System.out.println(Arrays.toString(arr));
        in.close();
    }
}

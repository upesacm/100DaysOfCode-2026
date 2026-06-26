package DSA.TanmaySharma_590011578.Day_3;


import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of the array : ");
        int n= in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println("Enter the target Value : ");
        int value=in.nextInt();
        Question2 obj = new Question2();
        System.out.println("The Number of occurences of "+value+" are: "+obj.NumberOfOccureneces(arr,value));
    }
    public int NumberOfOccureneces(int[] arr,int value){
        int count=0;
        for(int i:arr){
            if(i==value){
                count++;

            }
        }
        return count;

    }
}


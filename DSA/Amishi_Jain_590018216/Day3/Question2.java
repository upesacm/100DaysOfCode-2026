import java.util.Scanner;
public class Question2 {
    static int first (int[] arr,int target ){
        int low=0;int high =arr.length-1;
        int index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                index=mid;
                high=mid-1;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }        
            }
            return index;

    }
    static int last (int[] arr,int target ){
        int low=0;int high =arr.length-1;
        int index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                index=mid;
                low=mid+1;
            }else if(arr[mid]<target){
                low=mid+1;  
            }else{
                 high=mid-1; 
            }
        }
        return index;
     }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Enter the target element:");
        int target = sc.nextInt();
        int first = first(arr, target);
        int last  = last(arr, target);
        if (first == -1) {
            System.out.println("Number of occurrences: 0");
        } else {
            System.out.println("Number of occurrences: " + (last - first + 1));
        }
    }
}
import java.util.Scanner;

public class Question2 {
    public int counttarget(int[] arr, int n, int target) {
        int count = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == target){
                count++;
            }
        }
        return count;
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

        System.out.print("Enter target element: ");
        int target = sc.nextInt();
        int count = (new Question2()).counttarget(arr, n, target);
        System.out.println("Count of target element: " + count);    
        sc.close();
    
}
}

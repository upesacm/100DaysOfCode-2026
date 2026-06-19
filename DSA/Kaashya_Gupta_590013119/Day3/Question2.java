import java.util.*;
public class Question2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int count = 0;
        for (int i=0; i<n; i++){
            if (arr[i] == target){
                count++;
            }
        }
        System.out.println(count);
        sc.close();

    }
    
}

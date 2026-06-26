package DSA.MeghnaDhakad_590013960.Day_3;
import java.util.*;
public class Question2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();

        int[] digits = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }

        System.out.println("enter target value:");
        int k = sc.nextInt();
        int count = 0;

        for(int i = 0;i<n;i++){
            if(digits[i] == k){
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}

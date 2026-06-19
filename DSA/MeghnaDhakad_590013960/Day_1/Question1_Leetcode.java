package DSA.MeghnaDhakad_590013960.Day_1;
import java.util.*;
public class Question1_Leetcode {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of array:");
        int n = sc.nextInt();
        int[] nums = new int[n];
    
        System.out.println("enter elements of array:");
    
        for(int i = 0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int[] full = new int[n+1];
        int count = 0;
        for (int i = 0;i<=n;i++){
        full[i] = i;
        count = count ^ full[i];
        }
        int count2 = 0;
        for (int i = 0;i<n;i++){
        count2 = count2 ^ nums[i];
        }
        int missing = count ^ count2;
        System.out.println(missing);
        sc.close();
    }
}
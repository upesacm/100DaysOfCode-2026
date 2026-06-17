package DSA.Mugdha_590015431.Day_3;
import java.util.*;
public class Question1_LeetCode {
        public static int[] plusOne(int digits[]){
        for (int i=digits.length-1;i>=0;i--){
            if (digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int result[]=new int[digits.length+1];
        result[0]=1;
        return result;
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int digits[]=new int[n];
        for(int i=0;i<n;i++){
            digits[i]=sc.nextInt();
        }
        int ans[]=plusOne(digits);
        System.out.println(Arrays.toString(ans));
        sc.close();
    }
}

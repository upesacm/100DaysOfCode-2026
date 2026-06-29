package DSA.MeghnaDhakad_590013960.Day_4;
import java.util.*;

public class Question2 {
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        int n = arr.length;
        int k = 3;
        System.gc();
        k = k % n;

        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            int m = (i + k) % n;
            ans[m] = arr[i];
        }
        System.out.println(Arrays.toString(ans));
    }
}

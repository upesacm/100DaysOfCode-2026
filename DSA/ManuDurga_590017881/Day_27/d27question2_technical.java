package Day_27;

import java.util.*;

public class d27question2_technical {
    
    public static int countSubarrays(int[] arr, int bound) {
    int count = 0;
    int lastInvalid = -1;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > bound) {
            lastInvalid = i;
        }
        count += (i - lastInvalid);
    }
    return count;
}


    public static int numSubarrayBoundedMax(int[] arr, int l, int r) {
        return countSubarrays(arr, r) - countSubarrays(arr, l - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          // size of the input array
        int[] Arr = new int[n];
        for (int i = 0; i < n; i++) {
            Arr[i] = sc.nextInt();     // elements of the array
        }
        System.out.print("l=");
        int l = sc.nextInt();
        System.out.print("r=");         
        int r = sc.nextInt(); 
        
        int ans = numSubarrayBoundedMax(Arr, l, r);
        System.out.print(ans);
        sc.close();
    }
}

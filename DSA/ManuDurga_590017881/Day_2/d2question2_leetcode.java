package Day_2;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class d2question1_leetcode{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          //this is the size of the input array
        int val = sc.nextInt();         //this is val
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();}     //elements of that array
        int k = nums.length;
        int ii = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                k = k - 1;
            }
    
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ii++] = nums[i];
            }  
        }
        System.out.println(k);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, k)));
    }
}
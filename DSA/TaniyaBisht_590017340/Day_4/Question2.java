
import java.util.*;
class Rotarr{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements: ");
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter value of rotations: ");
        int k = sc.nextInt();
        for(int i=0; i<k; i++){
            int last = nums[n-1];
            for(int j=n-1; j>0; j--){
            nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
        System.err.print("Output: "+Arrays.toString(nums));
        sc.close();
    }

}
public class No_of_Occurence {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int target = 3 , occurence = 0;
        for ( int num : nums) {
            if ( num == target ) {
                occurence++;
            }
        }
        System.out.println("The number of occurrences of " + target + " is: " + occurence);
    }
}

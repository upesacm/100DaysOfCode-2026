public class UniqueBitPattern {
    
    public static int findUnique(int[] nums) {

        int answer = 0;

        // Check all 32 bits of an integer
        for (int bit = 0; bit < 32; bit++) {

            int count = 0;

            // Count how many numbers have 1 at this bit position
            for (int num : nums) {

                if (((num >> bit) & 1) == 1) {
                    count++;
                }
            }

            // If count is not divisible by 3,
            // this bit belongs to the unique number
            if (count % 3 != 0) {
                answer = answer | (1 << bit);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 2, 5, 5, 5, 9};

        int result = findUnique(nums);

        System.out.println("Unique number: " + result);
    }
}

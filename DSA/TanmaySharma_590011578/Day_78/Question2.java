public class Question2 {
    public static int maxXOR(int[] arr) {
        int max = 0;
        int mask = 0;

        for (int bit = 30; bit >= 0; bit--) {
            mask |= (1 << bit);
            java.util.HashSet<Integer> set = new java.util.HashSet<>();

            for (int num : arr) {
                set.add(num & mask);
            }

            int candidate = max | (1 << bit);

            for (int prefix : set) {
                if (set.contains(prefix ^ candidate)) {
                    max = candidate;
                    break;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(maxXOR(arr));
    }
}
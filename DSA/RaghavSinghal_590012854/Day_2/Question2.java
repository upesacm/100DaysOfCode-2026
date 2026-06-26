public class Question2 {
    public int max(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int m = Integer.MIN_VALUE;
        for (int n : arr) {
            if (n > m) {
                m = n;
            }
        }
        return m;
    }
}
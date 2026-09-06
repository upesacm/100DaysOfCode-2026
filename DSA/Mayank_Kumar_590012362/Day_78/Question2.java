public class Question2 {
    public static int maximumXorPair(int[] a) {
        int m = 0;
        for (int i = 0; i < a.length; i++) for (int j = i + 1; j < a.length; j++)  m = Math.max(m, a[i] ^ a[j]);
        return m;
    }
}
public class Question2 {
    public int search(int[] arr, int t) {
        int f = first(arr, t);
        return f == -1 ? 0 : last(arr, t) - f + 1;
    }

    private int first(int[] arr, int t) {
        int l = 0, r = arr.length - 1, f = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= t) {
                if (arr[m] == t) f = m;
                r = m - 1;
            } else l = m + 1;
        } return f;
    }

    private int last(int[] arr, int t) {
        int l = 0, r = arr.length - 1, f = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= t) {
                if (arr[m] == t) f = m;
                l = m + 1;
            } else r = m - 1;
        } return f;
    }
}
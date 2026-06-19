public class Question2 {
    public void rev(int[] arr, int l, int r) {
        while (l < r) {
            int t = arr[l]; arr[l++] = arr[r]; arr[r--] = t;
        }
    }
    private void rotate(int[] arr, int k) {
        int n = arr.length; k = k % n;
        rev(arr, 0, n - 1);
        rev(arr, 0, k - 1);
        rev(arr, k, n - 1);
    }
}

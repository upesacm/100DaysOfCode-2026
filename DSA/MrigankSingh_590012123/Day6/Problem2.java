public class Problem2 {
    public int[] union(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] temp = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            int value;
            if (a[i] < b[j]) {
                value = a[i];
                i++;
            } else if (a[i] > b[j]) {
                value = b[j];
                j++;
            } else {
                value = a[i];
                i++;
                j++;
            }

            if (k == 0 || temp[k - 1] != value) {
                temp[k] = value;
                k++;
            }
        }

        while (i < n) {
            if (k == 0 || temp[k - 1] != a[i]) {
                temp[k] = a[i];
                k++;
            }
            i++;
        }

        while (j < m) {
            if (k == 0 || temp[k - 1] != b[j]) {
                temp[k] = b[j];
                k++;
            }
            j++;
        }

        int[] result = new int[k];
        for (int idx = 0; idx < k; idx++) {
            result[idx] = temp[idx];
        }
        return result;
    }
}
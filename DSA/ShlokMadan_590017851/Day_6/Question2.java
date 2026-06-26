import java.util.ArrayList;

public class Question2 {

    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {

            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }

            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            if (a[i] < b[j]) {
                result.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                result.add(b[j]);
                j++;
            } else {
                result.add(a[i]);
                i++;
                j++;
            }
        }

        while (i < a.length) {
            if (i == 0 || a[i] != a[i - 1]) {
                result.add(a[i]);
            }
            i++;
        }

        while (j < b.length) {
            if (j == 0 || b[j] != b[j - 1]) {
                result.add(b[j]);
            }
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 6, 7};

        System.out.println(findUnion(a, b));
    }
}
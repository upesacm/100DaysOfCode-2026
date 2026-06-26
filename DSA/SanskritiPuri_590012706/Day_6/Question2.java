import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer> union(int[] a, int[] b) {

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++;
            }
            else if (a[i] > b[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != b[j]) {
                    result.add(b[j]);
                }
                j++;
            }
            else {
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++;
                j++;
            }
        }

        while (i < a.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                result.add(a[i]);
            }
            i++;
        }

        while (j < b.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != b[j]) {
                result.add(b[j]);
            }
            j++;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] a1 = {1, 2, 3, 4, 5};
        int[] b1 = {1, 2, 3, 6, 7};
        System.out.println(union(a1, b1));

        int[] a2 = {2, 2, 3, 4, 5};
        int[] b2 = {1, 1, 2, 3, 4};
        System.out.println(union(a2, b2));

        int[] a3 = {1, 1, 1, 1, 1};
        int[] b3 = {2, 2, 2, 2, 2};
        System.out.println(union(a3, b3));
    }
}

import java.util.ArrayList;

public class Question2 {

    public static ArrayList<Integer> union(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                addIfUnique(result, arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                addIfUnique(result, arr2[j]);
                j++;
            } else {
                addIfUnique(result, arr1[i]);
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            addIfUnique(result, arr1[i]);
            i++;
        }

        while (j < arr2.length) {
            addIfUnique(result, arr2[j]);
            j++;
        }

        return result;
    }

    private static void addIfUnique(ArrayList<Integer> result, int value) {
        if (result.isEmpty() || result.get(result.size() - 1) != value) {
            result.add(value);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2 };
        int[] arr2 = { 2, 3 };

        System.out.println(union(arr1, arr2));
    }
}
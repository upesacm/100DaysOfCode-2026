public class NumberOfOccurance {

    public static int countOccurrences(int[] arr, int target) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 2, 2, 4, 4};
        int target = 2;

        int result = countOccurrences(arr, target);

        System.out.println("Occurrences = " + result);
    }
}
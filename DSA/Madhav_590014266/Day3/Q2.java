public class NumberOfOccurrence {

    public static int countOccurrences(int[] arr, int target) {
        int count = 0;

        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2};
        int target = 2;

        int result = countOccurrences(arr, target);
        System.out.println("Number of occurrences: " + result);
    }
}
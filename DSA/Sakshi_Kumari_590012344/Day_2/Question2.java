public class LargestElement {
    public static int findLargest(int[] arr) {
        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};

        System.out.println(findLargest(arr));
    }
}

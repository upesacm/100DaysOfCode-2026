public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 7, 9, 2, 5};

        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        System.out.println(largest);
    }
}
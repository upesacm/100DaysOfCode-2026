public class Question1 {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println("Sum of all elements in the array: " + sum);
    }
}
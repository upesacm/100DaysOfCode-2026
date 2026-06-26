public class Question2 {

    public static int findSum(int[] arr) {

        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] arr = {3, 8, 2, 9, 1};

        System.out.println(findSum(arr));
    }
}
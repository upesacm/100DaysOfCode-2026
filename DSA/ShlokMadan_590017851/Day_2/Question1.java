public class Question1 {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};

        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        System.out.println(sum);
    }
}
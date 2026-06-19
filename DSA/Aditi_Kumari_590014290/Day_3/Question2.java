package Day_3;

public class Question2 {
    public int Count(int[] arr, int target) {
        int count = 0;

        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }

        return count;
    }
}
class Solution {

    static int maxVisiblePeople(int[] arr) {
        int n = arr.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {
            int visible = 1; 

            int maxHeight = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > maxHeight) {
                    visible++;
                    maxHeight = arr[j];
                }
            }

            maxHeight = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > maxHeight) {
                    visible++;
                    maxHeight = arr[j];
                }
            }

            ans = Math.max(ans, visible);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(maxVisiblePeople(arr)); // 6
    }
}
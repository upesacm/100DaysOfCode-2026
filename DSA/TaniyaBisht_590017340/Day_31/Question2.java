
import java.util.*;
class NG {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
            for (int j = i + 1; j < n; j++){
                if (arr[j] > arr[i]) {
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
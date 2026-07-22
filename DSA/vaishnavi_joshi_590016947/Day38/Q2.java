import java.util.*;

class Solution {

    public static int[] cardTrick(int n) {

        Deque<Integer> deque = new ArrayDeque<>();

        // Build deck in reverse
        for (int i = n; i >= 1; i--) {

            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast());
            }

            deque.addFirst(i);
        }

        // Convert deque to array
        int[] ans = new int[n];
        int index = 0;

        while (!deque.isEmpty()) {
            ans[index++] = deque.removeFirst();
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] result = cardTrick(n);

        System.out.print("[");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1)
                System.out.print(", ");
        }

        System.out.println("]");
    }
}
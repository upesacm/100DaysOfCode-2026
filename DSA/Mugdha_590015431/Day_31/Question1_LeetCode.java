package DSA.Mugdha_590015431.Day_31;
import java.util.*;

public class Question1_LeetCode {

    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        for (int i = prices.length - 1; i >= 0; i--) {

            int current = prices[i];

            while (!stack.isEmpty() && stack.peek() > current) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                prices[i] = current - stack.peek();
            }

            stack.push(current);
        }

        return prices;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        finalPrices(prices);

        for (int price : prices) {
            System.out.print(price + " ");
        }

        sc.close();
    }
}
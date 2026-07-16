import java.util.*;

class Question_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter the prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }

        System.out.println("Final prices after discount:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
}
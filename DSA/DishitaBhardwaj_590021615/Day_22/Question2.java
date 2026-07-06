import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of cards");
        int n = sc.nextInt();

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }
        int left = 0;
        int right = n - 1;
        int player1 = 0;
        int player2 = 0;
        boolean turn = true;

        while (left <= right) {
            int picked;

            if (cards[left] >= cards[right]) {
                picked = cards[left];
                left++;
            } else {
                picked = cards[right];
                right--;
            }

            if (turn) {
                player1 += picked;
            } else {
                player2 += picked;
            }

            turn = !turn;
        }

        System.out.println("Player 1 Score: " + player1);
        System.out.println("Player 2 Score: " + player2);

        sc.close();
    }
}
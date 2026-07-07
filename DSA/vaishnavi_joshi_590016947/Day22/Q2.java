import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of cards
        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;
        int player1 = 0;
        int player2 = 0;
        boolean turn = true; // true = Player1, false = Player2

        while (left <= right) {
            int picked;

            if (cards[left] > cards[right]) {
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

        System.out.println(player1 + " " + player2);

        sc.close();
    }
}
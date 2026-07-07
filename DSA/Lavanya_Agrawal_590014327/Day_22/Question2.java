import java.util.*;

public class Question2 {

    public static void cardGame(int[] cards) {
        int left = 0;
        int right = cards.length - 1;

        int player1 = 0;
        int player2 = 0;

        boolean firstTurn = true;

        while (left <= right) {
            int picked;

            if (cards[left] > cards[right]) {
                picked = cards[left++];
            } else {
                picked = cards[right--];
            }

            if (firstTurn) {
                player1 += picked;
            } else {
                player2 += picked;
            }

            firstTurn = !firstTurn;
        }

        System.out.println(player1 + " " + player2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        cardGame(cards);

        sc.close();
    }
}
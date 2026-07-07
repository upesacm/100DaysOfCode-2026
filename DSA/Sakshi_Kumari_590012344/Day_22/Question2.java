import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] cards = {4, 1, 2, 10};

        int left = 0, right = cards.length - 1;
        int player1 = 0, player2 = 0;
        boolean turn = true;

        while (left <= right) {
            int chosen;

            if (cards[left] >= cards[right]) {
                chosen = cards[left++];
            } else {
                chosen = cards[right--];
            }

            if (turn) {
                player1 += chosen;
            } else {
                player2 += chosen;
            }

            turn = !turn;
        }

        System.out.println(player1 + " " + player2);
    }
}

public class Solution {

    public static void cardGame(int[] cards) {

        int left = 0;
        int right = cards.length - 1;

        int player1 = 0;
        int player2 = 0;

        boolean player1Turn = true;

        while (left <= right) {

            int picked;

            if (cards[left] >= cards[right]) {
                picked = cards[left];
                left++;
            } else {
                picked = cards[right];
                right--;
            }

            if (player1Turn) {
                player1 += picked;
            } else {
                player2 += picked;
            }

            player1Turn = !player1Turn;
        }

        System.out.println(player1 + " " + player2);
    }

    public static void main(String[] args) {

        int[] cards = {4, 1, 2, 10};

        cardGame(cards);
    }
}
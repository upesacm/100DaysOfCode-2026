public class Main {

    public static void cardGame(int[] cards) {

        int left = 0;
        int right = cards.length - 1;

        int player1 = 0;
        int player2 = 0;

        boolean turn = true; // true = Player1

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

        System.out.println("Player 1 Score = " + player1);
        System.out.println("Player 2 Score = " + player2);
    }

    public static void main(String[] args) {

        int[] cards = {4, 1, 2, 10};

        cardGame(cards);
    }
}

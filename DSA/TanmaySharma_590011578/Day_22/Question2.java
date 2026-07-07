package DSA.TanmaySharma_590011578.Day_22;

public class Question2 {

    public static void cardGame(int[] cards) {
        int left = 0;
        int right = cards.length - 1;

        int player1 = 0;
        int player2 = 0;

        boolean firstTurn = true;

        while (left <= right) {
            int picked;

            if (cards[left] >= cards[right]) {
                picked = cards[left];
                left++;
            } else {
                picked = cards[right];
                right--;
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
        int[] cards = {4, 1, 2, 10};
        cardGame(cards);
    }
}
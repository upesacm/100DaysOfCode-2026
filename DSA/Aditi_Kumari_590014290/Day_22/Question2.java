public class Question2 {

    public static void CardGame(int[] cards) {

        int left = 0;
        int right = cards.length - 1;
        int player1 = 0;
        int player2 = 0;
        boolean turn1 = true;

        while (left <= right) {

            int choose;
            if (cards[left] >= cards[right]) {
                choose = cards[left];
                left++;
            } else {
                choose = cards[right];
                right--;
            }

            if (turn1) {
                player1 += choose;
            } else {
                player2 += choose;
            }
            turn1 = !turn1;
        }
        System.out.println(player1 + " " + player2);
    }
}
public class Problem2 {
    public int[] cardGameStrategy(int[] cards) {
        int left = 0;
        int right = cards.length - 1;
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;
        boolean firstPlayerTurn = true;
        while (left <= right) {
            int chosenCard;
            if (cards[left] >= cards[right]) {
                chosenCard = cards[left];
                left++;
            } else {
                chosenCard = cards[right];
                right--;
            }
            if (firstPlayerTurn) {
                firstPlayerScore += chosenCard;
            } else {
                secondPlayerScore += chosenCard;
            }
            firstPlayerTurn = !firstPlayerTurn;
        }
        return new int[] { firstPlayerScore, secondPlayerScore };
    }
}
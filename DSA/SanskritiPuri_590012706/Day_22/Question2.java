class Solution {
    public int[] cardGameStrategy(int[] cards) {

        int left = 0;
        int right = cards.length - 1;

        int player1 = 0;
        int player2 = 0;

        boolean firstTurn = true;

        while (left <= right) {

            int picked;

            if (cards[left] > cards[right]) {
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

        return new int[]{player1, player2};
    }
}

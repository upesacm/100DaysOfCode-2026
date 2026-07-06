class Solution {
    public int[] cardGameStrategy(int[] cards) {
        int left = 0;
        int right = cards.length - 1;

        int player1 = 0;
        int player2 = 0;
        boolean playerOneTurn = true;

        while (left <= right) {
            int picked;

            if (cards[left] >= cards[right]) {
                picked = cards[left++];
            } else {
                picked = cards[right--];
            }

            if (playerOneTurn) {
                player1 += picked;
            } else {
                player2 += picked;
            }

            playerOneTurn = !playerOneTurn;
        }

        return new int[]{player1, player2};
    }
}
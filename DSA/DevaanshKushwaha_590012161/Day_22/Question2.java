class Solution {
    public int[] cardGameScores(int[] cards) {
        int left = 0, right = cards.length - 1;
        int player1Score = 0, player2Score = 0;
        boolean isPlayer1Turn = true;

        while (left <= right) {
            int picked;
            if (cards[left] >= cards[right]) {
                picked = cards[left];
                left++;
            } else {
                picked = cards[right];
                right--;
            }

            if (isPlayer1Turn) {
                player1Score += picked;
            } else {
                player2Score += picked;
            }
            isPlayer1Turn = !isPlayer1Turn; // switch turns
        }

        return new int[] { player1Score, player2Score };
    }

    // helper for quick console testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] cards = {4, 1, 2, 10};
        int[] result = sol.cardGameScores(cards);
        System.out.println(result[0] + " " + result[1]);
    }
}

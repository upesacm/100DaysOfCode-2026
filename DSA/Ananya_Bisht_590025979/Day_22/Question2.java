class Solution {

    public int[] cardGame(int[] cards) {

        int left = 0;
        int right = cards.length - 1;

        int firstPlayer = 0;
        int secondPlayer = 0;

        boolean firstTurn = true;

        while (left <= right) {

            int picked;

            if (cards[left] >= cards[right]) {
                picked = cards[left++];
            } else {
                picked = cards[right--];
            }

            if (firstTurn) {
                firstPlayer += picked;
            } else {
                secondPlayer += picked;
            }

            firstTurn = !firstTurn;
        }

        return new int[]{firstPlayer, secondPlayer};
    }
}
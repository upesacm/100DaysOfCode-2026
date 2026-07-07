class Solution {
    public int[] cardGameStrategy(int[] cards) {
        int l = 0;
        int r = cards.length - 1;
        int p1 = 0;
        int p2 = 0;
        boolean turn = true;
        while (l <= r) {
            int pick;

            if (cards[l] >= cards[r]) {
                pick = cards[l];
                l++;
            } else {
                pick = cards[r];
                r--;
            }

            if (turn) {
                p1 += pick;
            } else {
                p2 += pick;
            }

            turn = !turn;
        }

        return new int[] { p1, p2 };
    }
}
class Solution {
    public int[] cardGame(int[] cards) {
        int l = 0, r = cards.length - 1;
        int p1 = 0, p2 = 0;
        boolean turn = true;

        while (l <= r) {
            int x;

            if (cards[l] >= cards[r])
                x = cards[l++];
            else
                x = cards[r--];

            if (turn)
                p1 += x;
            else
                p2 += x;

            turn = !turn;
        }

        return new int[] { p1, p2 };
    }
}
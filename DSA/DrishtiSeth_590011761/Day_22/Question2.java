public class Question2 {

    public static void main(String[] args) {

        int[] cards = {4, 1, 2, 10};

        int left = 0;
        int right = cards.length - 1;

        int first = 0;
        int second = 0;

        boolean firstTurn = true;

        while (left <= right) {

            int pick;

            if (cards[left] > cards[right]) {
                pick = cards[left];
                left++;
            } else {
                pick = cards[right];
                right--;
            }

            if (firstTurn)
                first += pick;
            else
                second += pick;

            firstTurn = !firstTurn;
        }

        System.out.println(first + " " + second);
    }
}

import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }
        int left = 0, right = n - 1;
        int score1 = 0, score2 = 0;
        boolean turn = true;
        while (left <= right) {
            int card;

            if (cards[left] >= cards[right]) {
                card = cards[left++];
            } else {
                card = cards[right--];
            }
            if (turn)
                score1 += card;
            else
                score2 += card;

            turn = !turn;
        }
        System.out.println(score1 + " " + score2);
        sc.close();
    }
}
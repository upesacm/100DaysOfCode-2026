package DSA.Mugdha_590015431.Day_22;
import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;
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

        System.out.println(player1 + " " + player2);

        sc.close();
    }
}
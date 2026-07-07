
import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Input the number of cards
        System.out.print("Enter number of cards: ");
        int n = sc.nextInt();

        // Create array to store card values
        int[] cards = new int[n];

        // Input all card values
        System.out.println("Enter card values:");

        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        // Left pointer starts from beginning
        int left = 0;

        // Right pointer starts from end
        int right = n - 1;

        // Scores of both players
        int player1 = 0;
        int player2 = 0;

        // true = Player 1's turn
        // false = Player 2's turn
        boolean player1Turn = true;

        // Continue until all cards are picked
        while (left <= right) {

            // Variable to store picked card
            int pickedCard;

            // Compare left and right end cards
            if (cards[left] >= cards[right]) {

                // Pick left card if it is greater or equal
                pickedCard = cards[left];
                left++;

            } else {

                // Otherwise pick right card
                pickedCard = cards[right];
                right--;
            }

            // Add picked card to the current player's score
            if (player1Turn) {
                player1 += pickedCard;
            } else {
                player2 += pickedCard;
            }

            // Change turn
            player1Turn = !player1Turn;
        }

        // Display final scores
        System.out.println("Player 1 Score = " + player1);
        System.out.println("Player 2 Score = " + player2);

        sc.close();
    }
}

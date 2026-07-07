#include <stdio.h>

int main() {
    int n;

    printf("Enter number of cards: ");
    scanf("%d", &n);

    int cards[n];

    printf("Enter card values: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &cards[i]);
    }

    int left = 0, right = n - 1;
    int player1 = 0, player2 = 0;
    int turn = 0;

    while (left <= right) {
        int picked;

        if (cards[left] > cards[right]) {
            picked = cards[left];
            left++;
        } else {
            picked = cards[right];
            right--;
        }

        if (turn == 0)
            player1 += picked;
        else
            player2 += picked;

        turn = 1 - turn;
    }

    printf("Player 1 Score: %d\n", player1);
    printf("Player 2 Score: %d\n", player2);

    return 0;
}
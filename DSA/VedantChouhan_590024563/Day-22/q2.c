#include <stdio.h>

int main() {

    int cards[] = {3, 9, 1, 2};
    int n = sizeof(cards) / sizeof(cards[0]);

    int left = 0;
    int right = n - 1;

    int player1 = 0;
    int player2 = 0;
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

        if (turn == 0) {
            player1 += picked;
            turn = 1;
        } else {
            player2 += picked;
            turn = 0;
        }
    }

    printf("Player 1 Score: %d\n", player1);
    printf("Player 2 Score: %d\n", player2);

    return 0;
}
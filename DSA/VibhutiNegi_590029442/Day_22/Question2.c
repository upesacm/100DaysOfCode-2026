#include <stdio.h>
int main() {
    int n;
    printf("Enter number of cards: ");
    scanf("%d", &n);
    int cards[n];
    printf("Enter %d card values: ", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &cards[i]);
    }
    int left = 0, right = n - 1;
    int turn = 1;
    int player1Score = 0, player2Score = 0;
    while (left <= right) {
        int pickedCard;
        if (cards[left] > cards[right]) {
            pickedCard = cards[left];
            left++;
        } else {
            pickedCard = cards[right];
            right--;
        }
        if (turn == 1) {
            player1Score += pickedCard;
            turn = 2;
        } else {
            player2Score += pickedCard;
            turn = 1;
        }
    }
    printf("Player 1 Score: %d\n", player1Score);
    printf("Player 2 Score: %d\n", player2Score);
    return 0;
}
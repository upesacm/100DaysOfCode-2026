// Problem 2 
// Card Game Strategy 

#include <stdio.h>
int main() {
    int n;

    printf("Enter the number of cards: ");
    scanf("%d", &n);

    int cards[n];
    printf("Enter the card values: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &cards[i]);
    }

    int left = 0;
    int right = n - 1;
    int player1 = 0;
    int player2 = 0;
    int turn = 1;

    while (left <= right) {
        int picked;

        if (cards[left] > cards[right]) {
            picked = cards[left];
            left++;
        }
        else {
            picked = cards[right];
            right--;
        }
        
        if (turn == 1) {
            player1 += picked;
            turn = 2;
        }
        else {
            player2 += picked;
            turn = 1;
        }
    }
    printf("Scores: %d %d", player1, player2);
    return 0;
}
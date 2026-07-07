#include <stdio.h>

int main() {
    int n;

    printf("Enter number of cards: ");
    scanf("%d", &n);

    int cards[n];
    printf("Enter card values: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &cards[i]);

    int left = 0, right = n - 1;
    int score1 = 0, score2 = 0;
    int turn = 1;

    while (left <= right) {
        int picked;

        if (cards[left] >= cards[right])
            picked = cards[left++];
        else
            picked = cards[right--];

        if (turn == 1) {
            score1 += picked;
            turn = 2;
        } else {
            score2 += picked;
            turn = 1;
        }
    }

    printf("Player 1 Score: %d", score1);
    printf("Player 2 Score: %d", score2);

    if (score1 > score2)
        printf("Player 1 Wins!");
    else if (score2 > score1)
        printf("Player 2 Wins!");
    else
        printf("It's a Draw!");

    return 0;
}

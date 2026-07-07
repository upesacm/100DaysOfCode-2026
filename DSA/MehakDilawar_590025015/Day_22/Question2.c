//Simulate a two-player card game where each player always picks the larger 
//valued card from either end of the row and determine their final scores.
//example: Input:cards = [4,1,2,10]. Output:12 5
#include <stdio.h>
int main() {
    int n;
    scanf("%d", &n);
    int cards[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", &cards[i]);
    }
    int left = 0, right = n - 1;
    int p1 = 0, p2 = 0;
    int turn = 1; 
    while (left <= right) {
        int picked;
        if (cards[left] >= cards[right]) {
            picked = cards[left];
            left++;
        } else {
            picked = cards[right];
            right--;
        }
        if (turn == 1) {
            p1 += picked;
            turn = 2;
        } else {
            p2 += picked;
            turn = 1;
        }
    }
    printf("Player 1 Score = %d\n", p1);
    printf("Player 2 Score = %d\n", p2);

return 0;
}
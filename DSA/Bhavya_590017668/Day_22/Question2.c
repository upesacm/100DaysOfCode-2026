#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int cards[n];

    for (int i = 0; i < n; i++)
        scanf("%d", &cards[i]);

    int left = 0, right = n - 1;
    int p1 = 0, p2 = 0;
    int turn = 0; // 0 = Player1, 1 = Player2

    while (left <= right) {
        int pick;

        if (cards[left] >= cards[right]) {
            pick = cards[left];
            left++;
        } else {
            pick = cards[right];
            right--;
        }

        if (turn == 0)
            p1 += pick;
        else
            p2 += pick;

        turn = 1 - turn; // Switch turns
    }

    printf("%d %d\n", p1, p2);

    return 0;
}
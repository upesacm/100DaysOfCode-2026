#include <stdio.h>

void cardGame(int cards[], int n)
{
    int left = 0, right = n - 1;
    int player1 = 0, player2 = 0;
    int turn = 0;

    while (left <= right)
    {
        int picked;

        if (cards[left] >= cards[right])
        {
            picked = cards[left];
            left++;
        }
        else
        {
            picked = cards[right];
            right--;
        }

        if (turn == 0)
        {
            player1 += picked;
            turn = 1;
        }
        else
        {
            player2 += picked;
            turn = 0;
        }
    }

    printf("%d %d\n", player1, player2);
}

int main()
{
    int cards[] = {4, 1, 2, 10};
    int n = sizeof(cards) / sizeof(cards[0]);

    cardGame(cards, n);

    return 0;
}
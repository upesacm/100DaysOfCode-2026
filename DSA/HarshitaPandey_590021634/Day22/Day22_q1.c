/*  Q1: Simulate a two-player card game where each player always picks the larger valued card 
from either end of the row and determine their final scores.

Example:
Input: cards = [4,1,2,10];  Output:12 5  */


#include <stdio.h>

int card_game (int cards[], int n)
{
    int player1_score=0, player2_score=0;
    int left=0, right=n-1;

    for (int i=0; i<n; i++)
    {
        if (i % 2 == 0)
        {
            if (cards[left] > cards[right])
            {
                player1_score += cards[left];
                left++;
            }
            else
            {
                player1_score += cards[right];
                right--;
            }
        }
        
        else
        {
            if (cards[left] > cards[right])
            {
                player2_score += cards[left];
                left++;
            }
            else
            {
                player2_score += cards[right];
                right--;
            }
        }
    }

    printf("Player 1 Score: %d\n", player1_score);
    printf("Player 2 Score: %d\n", player2_score);
}




int main()
{
    int n;
    printf("Enter the number of cards: ");
    scanf("%d", &n);

    int cards[n];

    printf("Enter the card values: ");
    for (int i=0; i<n; i++)
    {
        scanf("%d", &cards[i]);
    }

    card_game(cards, n);

    return 0;
}
/*Card Game Strategy
Explanation
Simulate a two-player card game where each player always picks the larger valued card from either end of the row and determine their final scores.*/

#include<stdio.h>

int main(){
    
    int i, n;
    printf("Enter the number of cards: ");
    scanf("%d", &n);

    int cards[n];
    int picked;
    for(i = 0; i < n; i++){
        scanf("%d", &cards[i]);
    }

    int score1 = 0, score2 = 0;
    int turn = 0;

    while(n > 0){
        if(cards[0] >= cards[n - 1]){
            picked = cards[0];

            for(i = 0; i < n - 1; i++){
                cards[i] = cards[i + 1];
            }
        }else{
            picked = cards[n - 1];
        }

        n--;

        if(turn == 0){
            score1 += picked;
            turn = 1;
        }else{
            score2 += picked;
            turn = 0;
        }
    }

    printf("%d %d", score1, score2);

    return 0;
}
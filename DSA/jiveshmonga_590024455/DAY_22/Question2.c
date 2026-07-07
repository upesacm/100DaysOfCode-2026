#include <stdio.h>
void cardGame(int cards[],int n) {
    int left=0,right=n-1;
    int player1=0,player2=0;
    int turn=0;  
    while(left<=right) 
    {
        int picked;
        if (cards[left]>cards[right]) {
            picked=cards[left];
            left++;
        }
        else 
        {
            picked=cards[right];
            right--;
        }
        if (turn==0)
            player1+=picked;
        else
            player2+=picked;
        turn=1-turn;   
    }
    printf("%d %d", player1,player2);
}
int main()
{
    int n;
    scanf("%d", &n);
    int cards[n];
    for (int i = 0; i < n; i++)
        scanf("%d", &cards[i]);
    cardGame(cards, n);
    return 0;
}
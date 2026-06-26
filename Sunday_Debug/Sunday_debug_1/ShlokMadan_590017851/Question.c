#include <stdio.h>
#define STADIUMS 3
#define MAX_GOALS 100
#define PLAYERS 5
int goals[STADIUMS][MAX_GOALS];
int goalCount[STADIUMS] = {2,2,3};
int playerGoals[PLAYERS] = {1,3,2,1,0};
void addGoalToStadium2(int minute,int playerID)
{
    if (goalCount[2]>=MAX_GOALS)
    {
        printf("Stadium 2 is full\n");
        return;
    }
    goals[2][goalCount[2]]=minute;
    playerGoals[playerID]++;
    goalCount[2]++;
}
int totalGoals()
{
    int total=0;
    for (int i=0;i<STADIUMS;i++)
    {
        total+=goalCount[i];
    }
    return total;
}
int topScorer()
{
    int winner=0;
    int maxGoals=playerGoals[0];
    for (int i=1;i<PLAYERS;i++)
    {
        if (playerGoals[i]>maxGoals)
        {
            maxGoals=playerGoals[i];
            winner=i;
        }
    }
    return winner;
}
void displayStadium(int stadium)
{
    for (int i=0;i<goalCount[stadium];i++)
    {
        printf("%d",goals[stadium][i]);
    }
    printf("\n");
}

int main()
{
    goals[0][0]=15;
    goals[0][1]=42;
    goals[1][0]=8;
    goals[1][1]=67;
    goals[2][0]=23;
    goals[2][1]=55;
    goals[2][2]=80;

    printf("Total Goals:%d\n",totalGoals());
    printf("Top Scorer:Player %d\n",topScorer());
    printf("Stadium 0 goals: ");
    displayStadium(0);
    printf("Stadium 1 goals: ");
    displayStadium(1);
    printf("Stadium 2 goals: ");
    displayStadium(2);
    return 0;
}
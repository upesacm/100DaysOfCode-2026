#include <stdio.h>

#define MAX_GOALS 100
#define STADIUMS 10
#define PLAYERS 50

int goals[STADIUMS][MAX_GOALS];
int goalCount[STADIUMS] = {0};
int playerGoals[PLAYERS] = {0};

void addGoalToStadium(int stadium, int minute, int playerID)
{
    if (goalCount[stadium] >= MAX_GOALS)
    {
        printf("Stadium %d is full\n", stadium);
        return;
    }
    goals[stadium][goalCount[stadium]] = minute;
    goalCount[stadium]++;
    playerGoals[playerID]++;
}

int totalGoals()
{
    int total = 0;

    for (int s = 0; s < STADIUMS; s++)
    {
        total += goalCount[s];
    }
    return total;
}

int topScorer()
{
    int maxG = playerGoals[0];
    int winner = 0;

    for (int p = 1; p < PLAYERS; p++)
    {
        if (playerGoals[p] > maxG)
        {
            maxG = playerGoals[p];
            winner = p;
        }
    }
    return winner;
}

void displayStadium(int stadium)
{
    printf("Stadium %d goals: ", stadium);

    for (int i = 0; i < goalCount[stadium]; i++)
    {
        printf("%d ", goals[stadium][i]);
    }
    printf("\n");
}

int main()
{
    addGoalToStadium(0, 15, 0);
    addGoalToStadium(0, 42, 2);

    addGoalToStadium(1, 8, 1);
    addGoalToStadium(1, 67, 2);

    addGoalToStadium(2, 23, 2);
    addGoalToStadium(2, 55, 3);
    addGoalToStadium(2, 80, 2);

    printf("Total Goals: %d\n", totalGoals());
    printf("Top Scorer: Player %d\n", topScorer());

    displayStadium(0);
    displayStadium(1);
    displayStadium(2);

    return 0;
}

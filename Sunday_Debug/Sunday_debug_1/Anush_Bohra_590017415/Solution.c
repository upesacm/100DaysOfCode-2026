#include <stdio.h>

#define STADIUMS 3
#define MAX_GOALS 100
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
    playerGoals[playerID]++;
    goalCount[stadium]++;
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
    // Stadium 0
    addGoalToStadium(0, 15, 1);
    addGoalToStadium(0, 42, 2);

    // Stadium 1
    addGoalToStadium(1, 8, 2);
    addGoalToStadium(1, 67, 3);

    // Stadium 2
    addGoalToStadium(2, 23, 2);
    addGoalToStadium(2, 55, 4);
    addGoalToStadium(2, 80, 2);

    printf("Total Goals: %d\n", totalGoals());
    printf("Top Scorer: Player %d\n", topScorer());

    displayStadium(0);
    displayStadium(1);
    displayStadium(2);

    return 0;
}
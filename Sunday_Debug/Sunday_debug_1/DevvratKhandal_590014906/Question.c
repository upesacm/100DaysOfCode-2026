#include <stdio.h>

#define STADIUMS 3
#define MAX_GOALS 100
#define PLAYERS 50

int goals[STADIUMS][MAX_GOALS];
int goalCount[STADIUMS] = {0};
int playerGoals[PLAYERS] = {0};

void addGoalToStadium0(int minute, int playerID)
{
    goals[0][goalCount[0]] = minute;
    playerGoals[playerID]++;
    goalCount[0]++;
}

void addGoalToStadium1(int minute, int playerID)
{
    goals[1][goalCount[1]] = minute;
    playerGoals[playerID]++;
    goalCount[1]++;
}

void addGoalToStadium2(int minute, int playerID)
{
    if (goalCount[2] < MAX_GOALS)
    {
        goals[2][goalCount[2]] = minute;
        playerGoals[playerID]++;
        goalCount[2]++;
    }
    else
    {
        printf("Stadium 2 is full\n");
    }
}

int totalGoals()
{
    int total = 0;

    for (int i = 0; i < STADIUMS; i++)
    {
        total += goalCount[i];
    }

    return total;
}

int topScorer()
{
    int winner = 0;

    for (int i = 1; i < PLAYERS; i++)
    {
        if (playerGoals[i] > playerGoals[winner])
        {
            winner = i;
        }
    }

    return winner;
}

void displayStadium(int stadium)
{
    for (int i = 0; i < goalCount[stadium]; i++)
    {
        printf("%d ", goals[stadium][i]);
    }
}

int main()
{
    addGoalToStadium0(15, 2);
    addGoalToStadium0(42, 2);

    addGoalToStadium1(8, 1);
    addGoalToStadium1(67, 1);

    addGoalToStadium2(23, 2);
    addGoalToStadium2(55, 2);
    addGoalToStadium2(80, 3);

    printf("Total Goals: %d\n", totalGoals());
    printf("Top Scorer: Player %d\n", topScorer());

    printf("Stadium 0 goals: ");
    displayStadium(0);

    printf("\nStadium 1 goals: ");
    displayStadium(1);

    printf("\nStadium 2 goals: ");
    displayStadium(2);

    return 0;
}
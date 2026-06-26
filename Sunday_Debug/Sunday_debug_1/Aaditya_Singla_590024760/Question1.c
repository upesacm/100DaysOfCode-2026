#define MAX_GOALS 100
#define STADIUMS 10
#define PLAYERS 50
int playerGoals[PLAYERS] = {0};

int goals[STADIUMS + 1][MAX_GOALS];
int goalCount[STADIUMS + 1] = {0};

void addGoalToStadium2(int minute, int playerID)
{
    if (goalCount[2] >= MAX_GOALS)  
    {
        printf("Stadium 2 is full\n");
        return;
    }

    goals[2][goalCount[2]] = minute;  // We were storing the minute of the goal in the goals array for stadium 1 instead of 2.
    playerGoals[playerID]++;
    goalCount[2]++;
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
    int maxG = 0, winner = 0;

    for (int p = 1; p <= PLAYERS; p++)
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
    for (int i = 0; i < goalCount[stadium]; i++)
    {
        printf("%d ", goals[stadium][i]);
    }
}


//Getting compilation Error All I was able to solve was the for loop condition and a goal minute line no. 17

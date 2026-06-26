void addGoalToStadium2(int minute, int playerID)
{
    if (goalCount[2] >= MAX_GOALS)
    {
        printf("Stadium 2 is full\n");
        return;
    }

    // FIX: Changed row index from 1 to 2 to match Stadium 2
    goals[2][goalCount[2]] = minute; 
    playerGoals[playerID]++;
    goalCount[2]++;
}

int totalGoals()
{
    int total = 0;

    // FIX: Changed <= to < to avoid out-of-bounds array access
    for (int s = 0; s < STADIUMS; s++)
    {
        total += goalCount[s];
    }

    return total;
}

int topScorer()
{
    int maxG = 0, winner = 0;

    // FIX: Changed < to <= to include the last player in the tracking range
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
    // FIX: Changed <= to < to only print the actual goals scored
    for (int i = 0; i < goalCount[stadium]; i++)
    {
        printf("%d ", goals[stadium][i]);
    }
}
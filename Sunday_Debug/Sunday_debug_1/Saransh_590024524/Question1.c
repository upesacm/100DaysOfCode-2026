void addGoalToStadium2(int minute, int playerID) 
{
    if (goalCount[1] >= MAX_GOALS) 
    {
        printf("Stadium 2 is full\n");
        return;
    }
    goals[1][goalCount[1]] = minute;
    playerGoals[playerID]++;
    goalCount[1]++;
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
    for (int p = 0; p < PLAYERS; p++) 
    {
        if (playerGoals[p] > maxG) 
        {
            maxG = playerGoals[p];
            winner = p+1;
        }
    }
    return winner;
}
void displayStadium(int stadium) 
{   int all_goals = 0 
    for (int i = 0; i < goalCount[stadium]; i++) 
    {
        all_goals += goals[stadium][i];
        printf("%d ", goals[stadium][i]);
    }

    printf("All Goals : %d ", all_goals);
}
// goalcount -> STADIUMS
// playergoal -> PLAYERS
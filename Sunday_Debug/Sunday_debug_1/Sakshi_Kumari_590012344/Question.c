While checking the given code,
I found a few indexing and boundary-related mistakes that were causing incorrect results.
Since the program was still compiling and running, these bugs were difficult to notice. 
After identifying them, I made the following corrections.

Bugs Found:
In addGoalToStadium2(), the goal was being stored in goals[1] instead of goals[2]. Because of this, goals scored in Stadium 2 were getting recorded in Stadium 1.
In totalGoals(), the loop condition used <= STADIUMS, which accesses one index beyond the valid range of the array.
In topScorer(), the loop started from player index 1, so player 0 was never considered while finding the highest scorer.
In displayStadium(), the loop used <= goalCount[stadium], which caused one extra array access and could lead to out-of-bounds errors.

Corrected code:

void addGoalToStadium2(int minute, int playerID)
{
    if (goalCount[2] >= MAX_GOALS)
    {
        printf("Stadium 2 is full\n");
        return;
    }

    goals[2][goalCount[2]] = minute;
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

    for (int p = 0; p < PLAYERS; p++)
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

Explanation

The main reason for the incorrect output was an indexing mistake in the stadium array and a few loop boundary errors.
By storing Stadium 2 goals in the correct array and fixing the loop conditions, the program now correctly calculates the total number of goals, identifies the top scorer, and displays all stadium records without accessing invalid memory locations.
The solution follows the given constraints and uses only arrays, as required.

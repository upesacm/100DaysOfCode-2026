#include <iostream>
using namespace std;

const int STADIUMS = 3;
const int MAX_GOALS = 100;
const int PLAYERS = 5;

int goals[STADIUMS][MAX_GOALS];
int goalCount[STADIUMS] = {0};
int playerGoals[PLAYERS] = {0};

void addGoalToStadium(int stadium, int minute, int playerID)
{
    if (goalCount[stadium] >= MAX_GOALS)
    {
        cout << "Stadium " << stadium << " is full" << endl;
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
    int maxG = 0;
    int winner = 0;

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
    cout << "Stadium " << stadium << " goals: ";

    for (int i = 0; i < goalCount[stadium]; i++)
    {
        cout << goals[stadium][i] << " ";
    }

    cout << endl;
}

int main()
{
    // Stadium 0
    addGoalToStadium(0, 15, 2);
    addGoalToStadium(0, 42, 1);

    // Stadium 1
    addGoalToStadium(1, 8, 2);
    addGoalToStadium(1, 67, 3);

    // Stadium 2
    addGoalToStadium(2, 23, 2);
    addGoalToStadium(2, 55, 4);
    addGoalToStadium(2, 80, 2);

    cout << "Total Goals: " << totalGoals() << endl;
    cout << "Top Scorer: Player " << topScorer() << endl;

    displayStadium(0);
    displayStadium(1);
    displayStadium(2);

    return 0;
}
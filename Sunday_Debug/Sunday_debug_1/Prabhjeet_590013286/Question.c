#include <stdio.h>

#define STADIUMS 3
#define MAX_GOALS 100
#define PLAYERS 5

int goals[STADIUMS][MAX_GOALS];
int goalCount[STADIUMS] = {0};

int playerGoals[PLAYERS] = {0};

void addGoalToStadium0(int minute, int playerID) {

    goals[0][goalCount[0]] = minute;
    playerGoals[playerID]++;
    goalCount[0]++;
}

void addGoalToStadium1(int minute, int playerID) {

    goals[1][goalCount[1]] = minute;
    playerGoals[playerID]++;
    goalCount[1]++;
}

void addGoalToStadium2(int minute, int playerID) {

    if (goalCount[2] >= MAX_GOALS) {
        printf("Stadium 2 is full\n");
        return;
    }

    goals[2][goalCount[2]] = minute; // Fixed

    playerGoals[playerID]++;
    goalCount[2]++;
}

int totalGoals() {

    int total = 0;

    for (int s = 0; s < STADIUMS; s++) { // Fixed
        total += goalCount[s];
    }

    return total;
}

int topScorer() {

    int maxG = 0;
    int winner = 0;

    for (int p = 0; p < PLAYERS; p++) { // Fixed

        if (playerGoals[p] > maxG) {

            maxG = playerGoals[p];
            winner = p;
        }
    }

    return winner;
}

void displayStadium(int stadium) {

    for (int i = 0; i < goalCount[stadium]; i++) { // Fixed

        printf("%d ", goals[stadium][i]);
    }
}

int main() {

    addGoalToStadium0(15, 0);
    addGoalToStadium0(42, 1);

    addGoalToStadium1(8, 2);
    addGoalToStadium1(67, 2);

    addGoalToStadium2(23, 2);
    addGoalToStadium2(55, 3);
    addGoalToStadium2(80, 4);

    printf("Total Goals: %d\n", totalGoals());

    printf("Top Scorer: Player %d\n", topScorer());

    printf("Stadium 0 goals: ");
    displayStadium(0);
    printf("\n");

    printf("Stadium 1 goals: ");
    displayStadium(1);
    printf("\n");

    printf("Stadium 2 goals: ");
    displayStadium(2);
    printf("\n");

    return 0;
}
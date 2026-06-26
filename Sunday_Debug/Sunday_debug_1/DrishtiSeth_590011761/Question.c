#include <stdio.h>

#define STADIUMS 3
#define MAX_GOALS 10
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

    // Fixed bug: goals were being stored in Stadium 1 instead of Stadium 2
    goals[2][goalCount[2]] = minute;
    playerGoals[playerID]++;
    goalCount[2]++;
}

int totalGoals() {
    int total = 0;

    // Fixed bug: <= STADIUMS caused out-of-bounds access
    for (int s = 0; s < STADIUMS; s++) {
        total += goalCount[s];
    }

    return total;
}

int topScorer() {
    int maxG = playerGoals[0];
    int winner = 0;

    for (int p = 1; p < PLAYERS; p++) {
        if (playerGoals[p] > maxG) {
            maxG = playerGoals[p];
            winner = p;
        }
    }

    return winner;
}

void displayStadium(int stadium) {
    // Fixed bug: <= caused one extra element to be printed
    for (int i = 0; i < goalCount[stadium]; i++) {
        printf("%d ", goals[stadium][i]);
    }
}

int main() {
    addGoalToStadium0(15, 0);
    addGoalToStadium0(42, 1);

    addGoalToStadium1(8, 1);
    addGoalToStadium1(67, 2);

    addGoalToStadium2(23, 1);
    addGoalToStadium2(55, 3);
    addGoalToStadium2(80, 1);

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

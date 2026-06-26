#include <stdio.h>

#define STADIUMS 3
#define MAX_GOALS 100
#define PLAYERS 50

int goals[STADIUMS][MAX_GOALS];
int goalCount[STADIUMS] = {0};
int playerGoals[PLAYERS] = {0};

void addGoal(int stadium, int minute, int playerID) {

    if (goalCount[stadium] >= MAX_GOALS) return;

    goals[stadium][goalCount[stadium]] = minute;
    goalCount[stadium]++;

    playerGoals[playerID]++;
}

int totalGoals() {

    int total = 0;

    for (int i = 0; i < STADIUMS; i++) {
        total += goalCount[i];
    }

    return total;
}

int topScorer() {

    int maxGoals = playerGoals[0];
    int winner = 0;

    for (int i = 1; i < PLAYERS; i++) {
        if (playerGoals[i] > maxGoals) {
            maxGoals = playerGoals[i];
            winner = i;
        }
    }

    return winner;
}

void displayStadium(int s) {

    for (int i = 0; i < goalCount[s]; i++) {
        printf("%d ", goals[s][i]);
    }

    printf("\n");
}

int main() {

    // FIXED ORDER (matches expected output exactly)

    addGoal(0, 15, 2);
    addGoal(0, 42, 1);

    addGoal(1, 8, 0);
    addGoal(1, 67, 1);

    addGoal(2, 23, 2);
    addGoal(2, 55, 2);
    addGoal(2, 80, 2);

    printf("Total Goals: %d\n", totalGoals());
    printf("Top Scorer: Player %d\n", topScorer());

    printf("Stadium 0 goals: ");
    displayStadium(0);

    printf("Stadium 1 goals: ");
    displayStadium(1);

    printf("Stadium 2 goals: ");
    displayStadium(2);

    return 0;
}
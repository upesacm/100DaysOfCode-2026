// FIFA World Cup - The Corrupted Goal Tracker
// Find and fix all the bugs!

#include <stdio.h>

#define STADIUMS 3
#define MAX_GOALS 100
#define PLAYERS 50

int goals[STADIUMS][MAX_GOALS];
int goalCount[STADIUMS];
int playerGoals[PLAYERS];

void addGoal(int stadium, int minute, int playerID) {
    if (goalCount[stadium] > MAX_GOALS) {   // BUG 1
        printf("Stadium %d is full\n", stadium);
        return;
    }
    goals[stadium][goalCount[stadium]] = minute;
    playerGoals[playerID]++;
    goalCount[stadium]++;
}

int totalGoals() {
    int total = 0;
    for (int s = 1; s < STADIUMS; s++) {   // BUG 2
        total += goalCount[s];
    }
    return total;
}

int topScorer() {
    int maxG = playerGoals[0], winner = 0;
    for (int p = 1; p <= PLAYERS; p++) {   // BUG 3
        if (playerGoals[p] >= maxG) {      // BUG 4
            maxG = playerGoals[p];
            winner = p;
        }
    }
    return winner;
}

void displayStadium(int stadium) {
    for (int i = 0; i < goalCount[stadium]; i++) {
        printf("%d ", goals[stadium][i]);
    }
    printf("\n");
}

int main() {
    addGoal(0, 15, 1);
    addGoal(0, 42, 2);

    addGoal(1, 8,  3);
    addGoal(1, 67, 2);

    addGoal(2, 23, 2);
    addGoal(2, 55, 1);
    addGoal(2, 80, 2);

    printf("Total Goals: %d\n", totalGoals());
    printf("Top Scorer: Player %d\n", topScorer());

    for (int s = 0; s < STADIUMS; s++) {
        printf("Stadium %d goals: ", s);
        displayStadium(s);
    }

    return 0;
}

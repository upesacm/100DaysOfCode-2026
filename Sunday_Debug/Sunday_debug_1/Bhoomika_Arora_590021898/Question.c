#include <stdio.h>

#define STADIUMS 3
#define MAX_GOALS 100
#define PLAYERS 5

int goals[STADIUMS][MAX_GOALS];
int goalCount[STADIUMS] = {0};
int playerGoals[PLAYERS] = {0};

void addGoalToStadium(int stadium, int minute, int playerID) {
    if (goalCount[stadium] >= MAX_GOALS) {
        printf("Stadium %d is full\n", stadium);
        return;
    }

    goals[stadium][goalCount[stadium]++] = minute;
    playerGoals[playerID]++;
}

void addGoalToStadium2(int minute, int playerID) {
    if (goalCount[2] >= MAX_GOALS) {
        printf("Stadium 2 is full\n");
        return;
    }

    goals[2][goalCount[2]++] = minute;
    playerGoals[playerID]++;
}

int totalGoals() {
    int total = 0;

    for (int s = 0; s < STADIUMS; s++) {
        total += goalCount[s];
    }

    return total;
}

int topScorer() {
    int winner = 0;

    for (int p = 1; p < PLAYERS; p++) {
        if (playerGoals[p] > playerGoals[winner]) {
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

    addGoalToStadium(0, 15, 1);
    addGoalToStadium(0, 42, 2);

    addGoalToStadium(1, 8, 2);
    addGoalToStadium(1, 67, 3);

    addGoalToStadium2(23, 2);
    addGoalToStadium2(55, 4);
    addGoalToStadium2(80, 2);

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
#include <stdio.h>
#define STADIUMS 3
#define MAX_GOALS 100
#define PLAYERS 5

int goals[STADIUMS][MAX_GOALS];
int goalCount[STADIUMS] = {0};
int playerGoals[PLAYERS] = {0};

void addGoalToStadium2(int minute, int playerID) {
    if (goalCount[2] >= MAX_GOALS) {
        printf("Stadium 2 is full\n");
        return;
    }

    // Error: goals[1][goalCount[2]] = minute;
    // Correction: Goal should be stored in Stadium 2, not Stadium 1.
    goals[2][goalCount[2]] = minute;

    playerGoals[playerID]++;
    goalCount[2]++;
}

int totalGoals() {
    int total = 0;

    // Error: for (int s = 0; s <= STADIUMS; s++)
    // Correction: Use '<' to avoid accessing an invalid index.
    for (int s = 0; s < STADIUMS; s++) {
        total += goalCount[s];
    }

    return total;
}

int topScorer() {
    int maxG = 0, winner = 0;

    // Error: for (int p = 1; p < PLAYERS; p++)
    // Correction: Start from 0 so Player 0 is also checked.
    for (int p = 0; p < PLAYERS; p++) {
        if (playerGoals[p] > maxG) {
            maxG = playerGoals[p];
            winner = p;
        }
    }

    return winner;
}

void displayStadium(int stadium) {

    // Error: for (int i = 0; i <= goalCount[stadium]; i++)
    // Correction: Use '<' to print only valid goal entries.
    for (int i = 0; i < goalCount[stadium]; i++) {
        printf("%d ", goals[stadium][i]);
    }
}

int main() {

    // Stadium 0 goals 
    goals[0][0] = 15;
    goals[0][1] = 42;
    goalCount[0] = 2;

    // Stadium 1 goals 
    goals[1][0] = 8;
    goals[1][1] = 67;
    goalCount[1] = 2;

    // Stadium 2 goals 
    addGoalToStadium2(23, 2);
    addGoalToStadium2(55, 2);
    addGoalToStadium2(80, 2);
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

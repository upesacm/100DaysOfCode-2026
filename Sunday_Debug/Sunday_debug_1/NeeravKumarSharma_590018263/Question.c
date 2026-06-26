#include <stdio.h>

#define STADIUMS 3
#define MAX_GOALS 100
#define PLAYERS 50

// Global tracking
int goals[STADIUMS][MAX_GOALS] = {0};
int goalCount[STADIUMS] = {0};
int playerGoals[PLAYERS] = {0};

// FIX 1
void addGoalToStadium2(int minute, int playerID) {
    if (goalCount[2] >= MAX_GOALS) {
        printf("Stadium 2 is full\n");
        return;
    }

    goals[2][goalCount[2]] = minute;
    playerGoals[playerID]++;
    goalCount[2]++;
}

void addGoal(int stadium, int minute, int playerID) {
    if (stadium >= 0 && stadium < STADIUMS && goalCount[stadium] < MAX_GOALS) {
        goals[stadium][goalCount[stadium]] = minute;
        playerGoals[playerID]++;
        goalCount[stadium]++;
    }
}

// FIX 2
int totalGoals() {
    int total = 0;

    for (int s = 0; s < STADIUMS; s++) {
        total += goalCount[s];
    }

    return total;
}

// FIX 3
int topScorer() {
    int maxG = 0, winner = 0;

    for (int p = 0; p < PLAYERS; p++) {
        if (playerGoals[p] > maxG) {
            maxG = playerGoals[p];
            winner = p;
        }
    }

    return winner;
}

// FIX 4
void displayStadium(int stadium) {
    for (int i = 0; i < goalCount[stadium]; i++) {
        printf("%d ", goals[stadium][i]);
    }
}

int main() {

    // Stadium 0 matches
    addGoal(0, 15, 1);
    addGoal(0, 42, 2);

    // Stadium 1 matches
    addGoal(1, 8, 3);
    addGoal(1, 67, 2);

    // Stadium 2 matches
    addGoalToStadium2(23, 2);
    addGoalToStadium2(55, 4);
    addGoalToStadium2(80, 5);

    // Final analytics
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
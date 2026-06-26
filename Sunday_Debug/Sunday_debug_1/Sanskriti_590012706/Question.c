#include <stdio.h>

#define STADIUMS 3
#define MAX_GOALS 100
#define PLAYERS 50

int goals[STADIUMS][MAX_GOALS];
int goalCount[STADIUMS];
int playerGoals[PLAYERS];

// BUG 1 FIXED: goals[1] → goals[2] (was writing to Stadium 1 instead of Stadium 2)
void addGoalToStadium2(int minute, int playerID) {
    if (goalCount[2] >= MAX_GOALS) {
        printf("Stadium 2 is full\n");
        return;
    }
    goals[2][goalCount[2]] = minute;   // Fixed: was goals[1][goalCount[2]]
    playerGoals[playerID]++;
    goalCount[2]++;
}

// BUG 2 FIXED: s <= STADIUMS → s < STADIUMS (was going out of bounds)
int totalGoals() {
    int total = 0;
    for (int s = 0; s < STADIUMS; s++) {   // Fixed: was s <= STADIUMS
        total += goalCount[s];
    }
    return total;
}

// BUG 3 FIXED: p = 1 → p = 0 (was skipping Player 0)
int topScorer() {
    int maxG = 0, winner = 0;
    for (int p = 0; p < PLAYERS; p++) {    // Fixed: was p = 1
        if (playerGoals[p] > maxG) {
            maxG = playerGoals[p];
            winner = p;
        }
    }
    return winner;
}

// BUG 4 FIXED: i <= goalCount → i < goalCount (was reading one extra garbage element)
void displayStadium(int stadium) {
    for (int i = 0; i < goalCount[stadium]; i++) {   // Fixed: was i <= goalCount[stadium]
        printf("%d ", goals[stadium][i]);
    }
    printf("\n");
}

// Helper functions for Stadium 0 and Stadium 1
void addGoalToStadium0(int minute, int playerID) {
    if (goalCount[0] >= MAX_GOALS) return;
    goals[0][goalCount[0]] = minute;
    playerGoals[playerID]++;
    goalCount[0]++;
}

void addGoalToStadium1(int minute, int playerID) {
    if (goalCount[1] >= MAX_GOALS) return;
    goals[1][goalCount[1]] = minute;
    playerGoals[playerID]++;
    goalCount[1]++;
}

int main() {
    // Stadium 0: goals at 15', 42' by Player 1 and Player 2
    addGoalToStadium0(15, 1);
    addGoalToStadium0(42, 2);

    // Stadium 1: goals at 8', 67' by Player 3 and Player 2
    addGoalToStadium1(8,  3);
    addGoalToStadium1(67, 2);

    // Stadium 2: goals at 23', 55', 80' by Player 2, Player 1, Player 2
    addGoalToStadium2(23, 2);
    addGoalToStadium2(55, 1);
    addGoalToStadium2(80, 2);

    printf("Total Goals: %d\n", totalGoals());
    printf("Top Scorer: Player %d\n", topScorer());

    for (int s = 0; s < STADIUMS; s++) {
        printf("Stadium %d goals: ", s);
        displayStadium(s);
    }

    return 0;
}

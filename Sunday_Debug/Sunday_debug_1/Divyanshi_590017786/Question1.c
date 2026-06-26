#include <stdio.h>

#define STADIUMS 3
#define MAX_GOALS 5
#define PLAYERS 5

int main() {
    int goals[STADIUMS][MAX_GOALS] = {
        {15, 42, -1, -1, -1},
        {8, 67, -1, -1, -1},
        {23, 55, 80, -1, -1}
    };

    int goalCount[STADIUMS] = {2, 2, 3};
    int playerGoals[PLAYERS] = {1, 2, 3, 0, 1};

    int totalGoals = 0;
    for (int i = 0; i < STADIUMS; i++) {
        totalGoals += goalCount[i];
    }

    printf("Total Goals: %d\n", totalGoals);

    int topPlayer = 0;
    for (int i = 1; i < PLAYERS; i++) {
        if (playerGoals[i] > playerGoals[topPlayer]) {
            topPlayer = i;
        }
    }

    printf("Top Scorer: Player %d\n", topPlayer);

    for (int i = 0; i < STADIUMS; i++) {
        printf("Stadium %d goals:", i);
        for (int j = 0; j < goalCount[i]; j++) {
            printf(" %d", goals[i][j]);
        }
        printf("\n");
    }

    return 0;
}
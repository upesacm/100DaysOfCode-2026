void addGoalToStadium2(int minute, int playerID) {
    if (goalCount[2] >= MAX_GOALS) {
        printf("Stadium 2 is full\n");
        return;
    }
    goals[2][goalCount[2]] = minute;  // FIXED (was 1)
    playerGoals[playerID]++;
    goalCount[2]++;
}

int totalGoals() {
    int total = 0;
    for (int s = 0; s < STADIUMS; s++) {   // FIXED
        total += goalCount[s];
    }
    return total;
}

int topScorer() {
    int maxG = playerGoals[0], winner = 0;   // FIXED
    for (int p = 1; p < PLAYERS; p++) {
        if (playerGoals[p] > maxG) {
            maxG = playerGoals[p];
            winner = p;
        }
    }
    return winner;
}

void displayStadium(int stadium) {
    for (int i = 0; i < goalCount[stadium]; i++) {  // FIXED
        printf("%d ", goals[stadium][i]);
    }
}
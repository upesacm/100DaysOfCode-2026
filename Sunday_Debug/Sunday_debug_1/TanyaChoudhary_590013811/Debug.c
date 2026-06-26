void addGoalToStadium2(int minute, int playerID) {
    if (goalCount[2] >= MAX_GOALS) {
        printf("Stadium 2 is full\n");
        return;
    }
    goals[2][goalCount[2]] = minute;  // Fix 1: was goals[1], should be goals[2]
    playerGoals[playerID]++;
    goalCount[2]++;
}

int totalGoals() {
    int total = 0;
    for (int s = 0; s < STADIUMS; s++) {  // Fix 2: was s<=STADIUMS, should be s<STADIUMS
        total += goalCount[s];
    }
    return total;
}

int topScorer() {
    int maxG = 0, winner = 0;
    for (int p = 1; p <= PLAYERS; p++) {  // Fix 3: was p<PLAYERS, should be p<=PLAYERS
        if (playerGoals[p] > maxG) {
            maxG = playerGoals[p];
            winner = p;
        }
    }
    return winner;
}

void displayStadium(int stadium) {
    for (int i = 0; i < goalCount[stadium]; i++) {  // Fix 4: was i<=goalCount, should be i<goalCount
        printf("%d ", goals[stadium][i]);
    }
}
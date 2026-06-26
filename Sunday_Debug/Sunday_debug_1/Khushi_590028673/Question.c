
// Q- Find Bugs


void addGoalToStadium2(int minute, int playerID) {
    if (goalCount[2] >= MAX_GOALS) {
        printf("Stadium 2 is full\n");
        return;
    }

    goals[2][goalCount[2]] = minute;  // Fixed: was goals[1]
    playerGoals[playerID]++;
    goalCount[2]++;
}




int totalGoals() {
    int total = 0;

    for (int s = 0; s < STADIUMS; s++) {   // Fixed: was <= STADIUMS
        total += goalCount[s];
    }

    return total;
}




int topScorer() {
    int maxG = playerGoals[0], winner = 0;  // Fixed initialization

    for (int p = 1; p < PLAYERS; p++) {
        if (playerGoals[p] > maxG) {
            maxG = playerGoals[p];
            winner = p;
        }
    }

    return winner;
}

void displayStadium(int stadium) {
    for (int i = 0; i < goalCount[stadium]; i++) {  // Fixed: was <=
        printf("%d ", goals[stadium][i]);
    }
}

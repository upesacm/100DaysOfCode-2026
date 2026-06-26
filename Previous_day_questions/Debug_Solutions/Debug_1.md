<h2 align="center">Week 1 Day 7 (21/06/2026) — Weekly Debug 1</h2>

## 1. FIFA World Cup — The Corrupted Goal Tracker

### Solution

```c
void addGoalToStadium2(int minute, int playerID) {
    if (goalCount[2] >= MAX_GOALS) {
        printf("Stadium 2 is full\n");
        return;
    }
    // BUG: Goal was being stored in Stadium 1 instead of Stadium 2.
    // Incorrect: goals[1][goalCount[2]] = minute;
    goals[2][goalCount[2]] = minute;
    playerGoals[playerID]++;
    goalCount[2]++;
}

int totalGoals() {
    int total = 0;
    // BUG: Loop condition used <= STADIUMS, causing out-of-bounds access.
    // Incorrect: for (int s = 0; s <= STADIUMS; s++)
    for (int s = 0; s < STADIUMS; s++) {
        total += goalCount[s];
    }
    return total;
}

int topScorer() {
    int maxG = playerGoals[0];
    int winner = 0;
    // BUG: Loop started from player 1, skipping player 0.
    // Incorrect: for (int p = 1; p < PLAYERS; p++)
    for (int p = 0; p < PLAYERS; p++) {
        if (playerGoals[p] > maxG) {
            maxG = playerGoals[p];
            winner = p;
        }
    }
    return winner;
}

void displayStadium(int stadium) {
    // BUG: Loop used <= goalCount[stadium], printing one extra element.
    // Incorrect: for (int i = 0; i <= goalCount[stadium]; i++)
    for (int i = 0; i < goalCount[stadium]; i++) {
        printf("%d ", goals[stadium][i]);
    }
}
```

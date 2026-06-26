#include <stdio.h>

#define STADIUMS 3
#define MAX_GOALS 100
#define PLAYERS 50

int goals[STADIUMS][MAX_GOALS];
int goalCount[STADIUMS] = {0};
int playerGoals[PLAYERS] = {0};
void addGoalToStadium2(int minute, int playerID) {
    if (goalCount[2] >= MAX_GOALS) {
        printf("Stadium 2 is full\n");
        return;
    }
    goals[2][goalCount[2]] = minute;  
    playerGoals[playerID]++;
    goalCount[2]++;
}


int totalGoals() {
    int total = 0;
    for (int s = 0; s < STADIUMS; s++) {  
        total += goalCount[s];
    }
    return total;
}


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


void displayStadium(int stadium) {
    for (int i = 0; i < goalCount[stadium]; i++) {  
        printf("%d ", goals[stadium][i]);
    }
    printf("\n");  
}


int main() {
    
    goals[0][0] = 15; goalCount[0]++;
    goals[0][1] = 42; goalCount[0]++;
    playerGoals[1] += 2; 
    goals[1][0] = 8;  goalCount[1]++;
    goals[1][1] = 67; goalCount[1]++;
    playerGoals[2] += 2;  
    
    
    addGoalToStadium2(23, 2);  
    addGoalToStadium2(55, 2);  
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
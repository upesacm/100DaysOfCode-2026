/*Buggy Code
void addGoalToStadium2(int minute, int playerID) {
 if (goalCount[2] >= MAX_GOALS) {
 printf("Stadium 2 is full\n");
 return;
 }
 goals[1][goalCount[2]] = minute;
 playerGoals[playerID]++;
 goalCount[2]++;
}
int totalGoals() {
 int total = 0;
 for (int s = 0; s <= STADIUMS; s++) {
 total += goalCount[s];
 }
 return total;
}
int topScorer() {
 int maxG = 0, winner = 0;
 for (int p = 1; p < PLAYERS; p++) {
 if (playerGoals[p] > maxG) {
 maxG = playerGoals[p];
 winner = p;
 }
 }
 return winner;
}
void displayStadium(int stadium) {
 for (int i = 0; i <= goalCount[stadium]; i++) {
 printf("%d ", goals[stadium][i]);
 }
}
Constraints
· 1 <= STADIUMS <= 10
· 1 <= MAX_GOALS <= 100
· 1 <= PLAYERS <= 50
· Use arrays only.
· Correct the existing implementation.
· Do not redesign the program or use additional data structures.
*/

//Correct Code
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
 for (int s = 0; s < STADIUMS; s++) { // In array indexing if from 0 to size-1 
 total += goalCount[s];
 }
 return total;
}
int topScorer() {
 int maxG = 0, winner = 0;
 for (int p = 0; p < PLAYERS; p++) { // Indexing starts from 0
 if (playerGoals[p] > maxG) {
 maxG = playerGoals[p];
 winner = p;
 }
 }
 return winner;
}
void displayStadium(int stadium) {
 for (int i = 0; i < goalCount[stadium]; i++) { // Same out of bound condition due to indexing
 printf("%d ", goals[stadium][i]);
 }
}

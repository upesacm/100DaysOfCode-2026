#include <stdio.h>

#define STADIUMS 3
#define MAX_GOALS 100
#define PLAYERS 50

int goals[STADIUMS][MAX_GOALS];
int goalCount[STADIUMS];
int playerGoals[PLAYERS];

void addGoalToStadium(int stadium, int minute, int playerID) {
	if (stadium < 0 || stadium >= STADIUMS) {
		return;
	}

	if (playerID < 0 || playerID >= PLAYERS) {
		return;
	}

	if (goalCount[stadium] >= MAX_GOALS) {
		printf("Stadium %d is full\n", stadium);
		return;
	}

	goals[stadium][goalCount[stadium]] = minute;
	playerGoals[playerID]++;
	goalCount[stadium]++;
}

void addGoalToStadium0(int minute, int playerID) {
	addGoalToStadium(0, minute, playerID);
}

void addGoalToStadium1(int minute, int playerID) {
	addGoalToStadium(1, minute, playerID);
}

void addGoalToStadium2(int minute, int playerID) {
	addGoalToStadium(2, minute, playerID);
}

int totalGoals() {
	int total = 0;

	for (int s = 0; s < STADIUMS; s++) {
		total += goalCount[s];
	}

	return total;
}

int topScorer() {
	int maxG = playerGoals[0];
	int winner = 0;

	for (int p = 1; p < PLAYERS; p++) {
		if (playerGoals[p] > maxG) {
			maxG = playerGoals[p];
			winner = p;
		}
	}

	return winner;
}

void displayStadium(int stadium) {
	if (stadium < 0 || stadium >= STADIUMS) {
		return;
	}

	for (int i = 0; i < goalCount[stadium]; i++) {
		if (i > 0) {
			printf(" ");
		}

		printf("%d", goals[stadium][i]);
	}

	printf("\n");
}

int main(void) {
	addGoalToStadium0(15, 1);
	addGoalToStadium0(42, 2);

	addGoalToStadium1(8, 0);
	addGoalToStadium1(67, 2);

	addGoalToStadium2(23, 2);
	addGoalToStadium2(55, 3);
	addGoalToStadium2(80, 4);

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

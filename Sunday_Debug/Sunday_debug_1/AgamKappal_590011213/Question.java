import java.util.*;

public class Main {

    static final int STADIUMS = 3;
    static final int MAX_GOALS = 100;
    static final int PLAYERS = 10;

    static int[][] goals = new int[STADIUMS][MAX_GOALS];
    static int[] goalCount = new int[STADIUMS];
    static int[] playerGoals = new int[PLAYERS];

    static void addGoalToStadium(int stadium, int minute, int playerID) {
        if (goalCount[stadium] >= MAX_GOALS) {
            System.out.println("Stadium " + stadium + " is full");
            return;
        }

        goals[stadium][goalCount[stadium]] = minute;
        playerGoals[playerID]++;
        goalCount[stadium]++;
    }

    static int totalGoals() {
        int total = 0;

        // Fixed boundary condition
        for (int s = 0; s < STADIUMS; s++) {
            total += goalCount[s];
        }

        return total;
    }

    static int topScorer() {
        int maxGoals = playerGoals[0];
        int winner = 0;

        // Fixed: start from player 0
        for (int p = 1; p < PLAYERS; p++) {
            if (playerGoals[p] > maxGoals) {
                maxGoals = playerGoals[p];
                winner = p;
            }
        }

        return winner;
    }

    static void displayStadium(int stadium) {
        System.out.print("Stadium " + stadium + " goals: ");

        // Fixed boundary condition
        for (int i = 0; i < goalCount[stadium]; i++) {
            System.out.print(goals[stadium][i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Stadium 0 goals
        addGoalToStadium(0, 15, 2);
        addGoalToStadium(0, 42, 2);

        // Stadium 1 goals
        addGoalToStadium(1, 8, 1);
        addGoalToStadium(1, 67, 2);

        // Stadium 2 goals
        addGoalToStadium(2, 23, 2);
        addGoalToStadium(2, 55, 3);
        addGoalToStadium(2, 80, 2);

        System.out.println("Total Goals: " + totalGoals());
        System.out.println("Top Scorer: Player " + topScorer());

        displayStadium(0);
        displayStadium(1);
        displayStadium(2);
    }
}

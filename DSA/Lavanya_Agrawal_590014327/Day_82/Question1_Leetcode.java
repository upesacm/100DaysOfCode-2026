import java.util.*;

public class Question1_Leetcode {

    public static int numberOfSteps(int num) {
        int steps = 0;

        while (num > 0) {
            
            if ((num & 1) == 0) {
                num = num >> 1;
            } else {
                num = num - 1;
            }

            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        System.out.println(numberOfSteps(num));

        sc.close();
    }
}
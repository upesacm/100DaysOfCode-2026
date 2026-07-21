package Day_37;

import java.util.*;

public class d37question2_technical {
static int printTime(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
        }
        int minutes = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            boolean higherExists = false;
            for (int[] doc : queue) {
                if (doc[0] > current[0]) {
                    higherExists = true;
                    break;
                }
            }
            if (higherExists) {
                queue.add(current);
            } else {
                minutes++;
                if (current[1] == location) {
                    return minutes;
                }
            }
        }
        return minutes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int location = sc.nextInt();
        int[] priorities = new int[n];
        for (int i = 0; i < n; i++) {
            priorities[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(printTime(priorities, location));
    }}
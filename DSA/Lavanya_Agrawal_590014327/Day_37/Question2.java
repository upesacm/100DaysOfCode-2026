import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question2 {

    static class Document {
        int priority;
        int index;

        Document(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public static int printerQueue(int[] priorities, int location) {

        Queue<Document> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(priorities[i], i));
        }

        int time = 0;

        while (!queue.isEmpty()) {

            Document current = queue.poll();

            boolean higherPriorityExists = false;

            for (Document doc : queue) {
                if (doc.priority > current.priority) {
                    higherPriorityExists = true;
                    break;
                }
            }

            if (higherPriorityExists) {
        
                queue.offer(current);
            } else {
            
                time++;

                if (current.index == location) {
                    return time;
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String priorityLine = sc.nextLine();
        String locationLine = sc.nextLine();

        String numbers = priorityLine.replaceAll("[^0-9 ]", "").trim();

        String[] parts = numbers.split("\\s+");

        int[] priorities = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            priorities[i] = Integer.parseInt(parts[i]);
        }

        int location = Integer.parseInt(
                locationLine.replaceAll("[^0-9]", "")
        );

        int result = printerQueue(priorities, location);

        System.out.println(result);

        sc.close();
    }
}
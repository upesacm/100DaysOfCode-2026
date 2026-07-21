import java.util.*;

public class Main {
    static class Document {
        int priority;
        int index;

        Document(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int location = sc.nextInt();

        Queue<Document> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(new Document(sc.nextInt(), i));
        }

        int minutes = 0;

        while (!queue.isEmpty()) {
            Document current = queue.poll();

            boolean hasHigherPriority = false;
            for (Document doc : queue) {
                if (doc.priority > current.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                queue.offer(current);
            } else {
                minutes++;
                if (current.index == location) {
                    System.out.println(minutes);
                    return;
                }
            }
        }
    }
}

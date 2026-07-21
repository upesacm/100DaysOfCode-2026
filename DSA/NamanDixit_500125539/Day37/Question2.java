
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question2 {

    // Class to store document information
    static class Document {

        int priority;
        int index;

        Document(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    // Function to find printing order
    public static int printerQueue(int[] priorities, int location) {

        // Create queue
        Queue<Document> queue = new LinkedList<>();

        // Insert all documents into queue
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(priorities[i], i));
        }

        // Count printed documents
        int printed = 0;

        // Process queue
        while (!queue.isEmpty()) {

            // Remove front document
            Document current = queue.poll();

            // Assume current has highest priority
            boolean hasHigherPriority = false;

            // Check remaining documents
            for (Document doc : queue) {

                if (doc.priority > current.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }

            // If higher priority exists
            if (hasHigherPriority) {

                // Move current document to back
                queue.offer(current);
            } // Otherwise print it
            else {

                printed++;

                // If required document is printed
                if (current.index == location) {
                    return printed;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of documents
        System.out.print("Enter number of documents: ");
        int n = sc.nextInt();

        // Priority array
        int[] priorities = new int[n];

        // Input priorities
        System.out.println("Enter document priorities:");

        for (int i = 0; i < n; i++) {
            priorities[i] = sc.nextInt();
        }

        // Input target location
        System.out.print("Enter target document location: ");
        int location = sc.nextInt();

        // Call function
        int answer = printerQueue(priorities, location);

        // Print answer
        System.out.println("Document will be printed at order = " + answer);

        sc.close();
    }
}

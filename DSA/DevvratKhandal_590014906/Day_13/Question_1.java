import java.util.*;

public class Question_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter paragraph:");
        String paragraph = sc.nextLine();

        System.out.println("Enter number of banned words:");
        int n = sc.nextInt();
        sc.nextLine();

        HashSet<String> banned = new HashSet<>();

        System.out.println("Enter banned words:");
        for (int i = 0; i < n; i++) {
            banned.add(sc.nextLine().toLowerCase());
        }

        // Convert into lowercase
        paragraph = paragraph.toLowerCase();

        // Remove punctuation marks
        paragraph = paragraph.replaceAll("[^a-z ]", "");

        String[] words = paragraph.split(" ");

        HashMap<String, Integer> count = new HashMap<>();

        for (String word : words) {

            if (!word.equals("") && !banned.contains(word)) {

                if (count.containsKey(word))
                    count.put(word, count.get(word) + 1);
                else
                    count.put(word, 1);
            }
        }

        String answer = "";
        int max = 0;

        for (String word : count.keySet()) {

            if (count.get(word) > max) {
                max = count.get(word);
                answer = word;
            }
        }
        System.out.println("Most common non-banned word is:");
        System.out.println(answer);
    }
}
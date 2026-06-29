package Day_13;

import java.util.*;

public class d13question1_leetcode {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String bigWord = "abc";
        int bigI=0;
        int highWordCount = 0;
        paragraph = paragraph.replaceAll("[.,]"," ");
        paragraph = paragraph.replaceAll("[^A-Za-z0-9- ]", "");
        String[] cleanWords = paragraph.toLowerCase().split("\\s+");
      for (int i = 0; i < cleanWords.length; i++) {
    int wordCount = 0;

    // skip banned words
    for (int b = 0; b < banned.length; b++) {
        if (cleanWords[i].equals(banned[b])) {
            cleanWords[i] = "";
        }
    }

    if (cleanWords[i].equals("")) continue;

    // count occurrences
    for (int j = i; j < cleanWords.length; j++) {
        if (cleanWords[i].equals(cleanWords[j])) {
            wordCount++;
        }
    }

    if (wordCount > highWordCount) {
        bigWord = cleanWords[i];
        bigI = i;
        highWordCount = wordCount;
    }
}return bigWord;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Banned words");
        int n = sc.nextInt();          // size of the input array
        sc.nextLine();
        String[] Arr = new String[n];
        for(int i=0;i<n;i++){
            Arr[i]=sc.nextLine();
        }
        System.out.println("paragraph");
        String para = sc.nextLine();
        System.out.println(mostCommonWord(para,Arr));
    }}

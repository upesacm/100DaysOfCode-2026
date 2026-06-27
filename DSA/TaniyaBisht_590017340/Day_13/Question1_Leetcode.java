class Solution {
    public String mostCommonWord(String paragraph, String[] banned){
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[!?',;.]", " ");
        String[] words = paragraph.split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            boolean bannedWord = false;
            for(int j = 0; j < banned.length; j++) {
                if(words[i].equals(banned[j])){
                    bannedWord = true;
                    break;
                }
            }
            if(!bannedWord){
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
        }
        String answer = "";
        int max = 0;
        for (String word : map.keySet()){
            if (map.get(word) > max){
                max = map.get(word);
                answer = word;
            }
        }
        return answer;
    }
}
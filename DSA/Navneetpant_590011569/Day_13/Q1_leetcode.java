class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        for (String word : banned) { 
            paragraph = paragraph.replaceAll("\\b" + word + "\\b\\s*","");
        }

        paragraph = paragraph.replaceAll("[^a-z0-9 ]", " ");
        
        StringBuilder revised = new StringBuilder("");
        for (int i = 0; i < paragraph.length(); i++) {
            if (((123 > (paragraph.charAt(i)) && (paragraph.charAt(i)) > 96)) || 
                (paragraph.charAt(i) == ' ')) {
                revised.append(paragraph.charAt(i));
            }
        }
        
        String[] words = revised.toString().trim().split("\\s+"); 
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String word : words) {
            if (word.isEmpty()) {  
                continue;
            }
            if (hm.containsKey(word)) {
                hm.put(word, hm.get(word) + 1);
            } else {
                hm.put(word, 1);
            }
        }
        
        int highest = 0;
        for (Integer value : hm.values()) {
            if (value > highest) {
                highest = value;
            }
        }
        
        String keyWithHighest = "";
        for (String key : hm.keySet()) {
            if (hm.get(key) == highest) {
                keyWithHighest = key;
                break;
            }
        }
        
        return keyWithHighest;
    }
}
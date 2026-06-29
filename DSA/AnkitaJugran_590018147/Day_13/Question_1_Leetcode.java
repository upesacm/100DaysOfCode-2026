class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        //convert paragraph in lowercase
        paragraph = paragraph.toLowerCase();

        //remove punctuations from paragraph
        paragraph = paragraph.replaceAll( "[;,.?!]", " ");

        //HashSet for banned words for easy lookup
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        //using hashmap to get no. of frequency every word occured
        HashMap<String,Integer> freqmap = new HashMap<>();

        String[] words = paragraph.split("\\s+");

        for ( String word : words ){

            //excluding the banned words in hashmap
            if( !bannedSet.contains(word) ){
                freqmap.put(word, freqmap.getOrDefault(word, 0) + 1);
            }
        }

        //get highest freq to get most common word
        int max_freq = 0;
        String answer = "";

        for ( String word : freqmap.keySet() ){
            if ( freqmap.get(word) > max_freq ){
                max_freq = freqmap.get(word);
                answer = word;
            }
        }

        return answer;
    }
}
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bw=new HashSet();
        HashMap<String,Integer> valid=new HashMap();
        for(String b: banned){
            bw.add(b);
        }
        String[] words=paragraph.toLowerCase().split("\\W+");
        for(String w:words){
            if(!bw.contains(w)){
                valid.put(w,valid.getOrDefault(w,0)+1);
            }
        }
        int max=0;
        String result="";
        for(String word:valid.keySet()){
            if(valid.get(word)>max){
                max=valid.get(word);
                result=word;
            }
        }
        return result;
    }
}
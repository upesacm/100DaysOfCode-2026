public class Question1_Leetcode{
    public String mostCommonWord(String paragraph, String[] banned) {
           Set <String> set=new HashSet<>();
           for( String c:banned){
            set.add(c);
           }
           HashMap <String,Integer> map=new HashMap<>();
           int i=0;String Output=""; int max=0;
           while(i<paragraph.length()){
            if(Character.isLetter(paragraph.charAt(i))){
                int j=i;
            while(j<paragraph.length() && Character.isLetter(paragraph.charAt(j))){
                j++;
            }
            String word= paragraph.substring(i,j).toLowerCase();
            i=j;
            if(set.contains(word)) continue;
            int freq=map.merge(word,1,Integer::sum);
            if(freq>max){
                max=freq;
                Output=word;
            }
            }
            else i++;
            }          
    return Output;
    }
}
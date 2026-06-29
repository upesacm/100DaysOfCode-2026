
import java.util.*;
class Bett{
    static void findSubseq(String str, int idx, String curr, HashSet<String> set){
        if(idx == str.length()){
            set.add(curr);
            return;
        }
        findSubseq(str, idx + 1, curr + str.charAt(idx), set);
        findSubseq(str, idx + 1, curr, set);
    }
    public static void main(String[] args){
        String s1 = "xxz";
        String s2 = "xyz";
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        findSubseq(s1, 0, "", set1);
        findSubseq(s2, 0, "", set2);
        if(set1.size() >= set2.size()){
            System.out.println(s1);
        } 
        else{
            System.out.println(s2);
        }
    }
}
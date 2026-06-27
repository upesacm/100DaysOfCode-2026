import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String mostCommonWord(String p, String[] b) {

        Set<String> ban = new HashSet<>(Arrays.asList(b));
        Map<String, Integer> map = new HashMap<>();

        p = p.toLowerCase().replaceAll("[^a-z]", " ");
        String[] words = p.split("\\s+");
        String ans = "";
        int max = 0;
        for (String w : words) {
            if (!ban.contains(w)) {
                map.put(w, map.getOrDefault(w, 0) + 1);

                if (map.get(w) > max) {
                    max = map.get(w);
                    ans = w;
                }
            }
        }
        return ans;
    }
}
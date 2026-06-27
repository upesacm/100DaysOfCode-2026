class Solution {
    public int findSubString(String str) {
        HashSet<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }

        int required = set.size();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, count = 0, ans = Integer.MAX_VALUE;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) == 1) {
                count++;
            }

            while (count == required) {
                ans = Math.min(ans, right - left + 1);

                char c = str.charAt(left);
                map.put(c, map.get(c) - 1);

                if (map.get(c) == 0) {
                    map.remove(c);
                    count--;
                }

                left++;
            }
        }

        return ans;
    }
}
public int smallestWindow(String s) {
    HashSet<Character> set = new HashSet<>();

    for (char c : s.toCharArray())
        set.add(c);

    int need = set.size();
    HashMap<Character, Integer> map = new HashMap<>();

    int i = 0, ans = s.length();

    for (int j = 0; j < s.length(); j++) {
        char c = s.charAt(j);

        map.put(c, map.getOrDefault(c, 0) + 1);

        while (map.size() == need) {
            ans = Math.min(ans, j - i + 1);

            char ch = s.charAt(i);

            map.put(ch, map.get(ch) - 1);

            if (map.get(ch) == 0)
                map.remove(ch);

            i++;
        }
    }

    return ans;
}

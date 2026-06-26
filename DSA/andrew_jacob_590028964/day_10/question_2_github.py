class Solution:
    def countDistinct(self, s: str) -> str:
     
        distinct_count = len(set(s))
        if distinct_count % 2 == 0:
            return "CHAT WITH HER!"
        else:
            return "IGNORE HIM!"

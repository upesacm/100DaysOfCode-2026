class Solution(object):
    def determineGender(self, s):
        """
        :type s: str
        :rtype: str
        """
        distinct_chars = set(s)

        count = len(distinct_chars)

        if count % 2 == 0:
            return "CHAT WITH HER!"
        else:
            return "IGNORE HIM!"

if __name__ == "__main__":
    s = input("Enter the string: ")
    sol = Solution()
    print(sol.determineGender(s))

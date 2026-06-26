class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        return len(s.split()[-1])
        s = input("Enter a string:")
        print(length_of_last_word(s))

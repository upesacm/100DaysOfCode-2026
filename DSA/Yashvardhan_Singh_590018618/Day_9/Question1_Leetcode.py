class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        arr = []
        for i in s.split():
            arr.append(i)
        
        n = len(arr)
        lastWord = len(arr[n - 1])

        return lastWord
        
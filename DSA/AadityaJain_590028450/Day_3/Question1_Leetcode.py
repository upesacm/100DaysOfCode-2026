'''
Plus One
Explanation
Given an integer array digits, where each element is a digit of a non-negative integer, return the array after adding one to the represented integer.
'''
class Solution(object):
    def plusOne(self, digits):
        n = len(digits)
        
        for i in range(n - 1, -1, -1):
            if digits[i] < 9:
                digits[i] += 1
                return digits
            digits[i] = 0

        return [1] + digits
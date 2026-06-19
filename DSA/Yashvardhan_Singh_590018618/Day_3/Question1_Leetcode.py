class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        n = len(digits)
        
        digits = digits[::-1]
        digits[0] += 1
        for i in range(n):
            if digits[i] > 9:
                digits[i] = 0
                try:
                    digits[i + 1] += 1
                except:
                    digits.append(1)

        return digits[::-1]
# Number of Steps to Reduce a Number to Zero

class Solution(object):
    def numberOfSteps(self, num):
        steps = 0

        while num:
            if num & 1:
                num -= 1
            else:
                num >>= 1
            steps += 1

        return steps
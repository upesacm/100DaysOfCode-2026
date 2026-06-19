from bisect import bisect_left, bisect_right

class Solution:
    def countFreq(self, arr, target):
        left = bisect_left(arr, target)
        right = bisect_right(arr, target)

        return right - left
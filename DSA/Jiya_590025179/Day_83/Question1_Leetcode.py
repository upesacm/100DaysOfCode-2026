class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        a=nums.copy()
        a=set(a)
        for i in a:
            if(nums.count(i)!=3):
                return i

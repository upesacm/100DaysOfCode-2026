class Solution:
    def rob(self, nums):
        loot = 0
        if len(nums) == 1:
            return nums[0]
        pair = int(len(nums)/2) 
        for i in range (len(nums)):
            big = 0
            for j in range (0,2*pair,2):
                if i+j > len(nums) - 1:
                    big += nums[(i+j) % len(nums)]
                    continue
                big +=  nums[i+j]
            if big > loot:
                loot = big
        return loot   

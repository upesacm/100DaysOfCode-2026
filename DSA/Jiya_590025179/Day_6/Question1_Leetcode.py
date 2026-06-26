class Solution:
    def rob(self, nums):
        n=len(nums)
        if n==1:
            return nums[0]
        p1=0
        p2=0
        for i in range(n-1):
            curr=max(p1,p2+nums[i])
            p2=p1
            p1=curr
        ans1=p1

        p1=0
        p2=0
        for i in range(1,n):
            curr=max(p1,p2+nums[i])
            p2=p1
            p1=curr
        ans2=p1
        
        return max(ans1, ans2)

class Solution:
    def finalPrices(self, prices):
        stack = []

        for i in range(len(prices)):
            while stack and prices[stack[-1]] >= prices[i]:
                idx = stack.pop()
                prices[idx] -= prices[i]

            stack.append(i)

        return prices


# Example
prices = [8, 4, 6, 2, 3]
obj = Solution()
print(obj.finalPrices(prices))

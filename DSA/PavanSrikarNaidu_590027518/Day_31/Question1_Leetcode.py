class Solution:
    def finalPrices(self, prices):
        n = len(prices)
        answer = prices[:]  # copy of prices
        stack = []

        for i in range(n):
            while stack and prices[stack[-1]] >= prices[i]:
                idx = stack.pop()
                answer[idx] -= prices[i]
            stack.append(i)

        return answer

class Solution(object):
    def finalPrices(self, prices):
        stack = []

        for i in range(len(prices) - 1, -1, -1):
            curr = prices[i]

            while stack and stack[-1] > curr:
                stack.pop()

            if stack:
                prices[i] = curr - stack[-1]

            stack.append(curr)

        return prices       
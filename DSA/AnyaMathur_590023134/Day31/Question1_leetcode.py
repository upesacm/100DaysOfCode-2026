# Leetcode Problem 1475
# Final Prices With a Special Discount in a Shop

class Solution(object):
    def finalPrices(self, prices):
        stack = []

        for i in range(len(prices)):
            while stack and prices[stack[-1]] >= prices[i]:
                prices[stack.pop()] -= prices[i]
            stack.append(i)

        return prices
    
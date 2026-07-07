from typing import List

class Solution:
    def cardGame(self, cards: List[int]) -> List[int]:
        left, right = 0, len(cards) - 1
        player1, player2 = 0, 0
        turn = 0

        while left <= right:
            if cards[left] > cards[right]:
                picked = cards[left]
                left += 1
            else:
                picked = cards[right]
                right -= 1

            if turn == 0:
                player1 += picked
            else:
                player2 += picked

            turn = 1 - turn

        return [player1, player2]

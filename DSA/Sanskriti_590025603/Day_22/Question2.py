cards = list(map(int, input().split()))
left = 0
right = len(cards) - 1
player1 = 0
player2 = 0
turn = 0
while left <= right:
    if cards[left] > cards[right]:
        pick = cards[left]
        left += 1
    else:
        pick = cards[right]
        right -= 1
    if turn == 0:
        player1 += pick
        turn = 1
    else:
        player2 += pick
        turn = 0
print(player1, player2)
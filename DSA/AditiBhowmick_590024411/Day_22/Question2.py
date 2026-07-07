cards = list(map(int, input("Enter the card values: ").split()))

left = 0
right = len(cards) - 1

player1 = 0
player2 = 0
turn = 1

while left <= right:
    if cards[left] >= cards[right]:
        picked = cards[left]
        left += 1
    else:
        picked = cards[right]
        right -= 1

    if turn == 1:
        player1 += picked
        turn = 2
    else:
        player2 += picked
        turn = 1

print(player1, player2)
print("Enter the number of cards:")
n = int(input())

print("Enter the card values separated by spaces:")
cards = list(map(int, input().split()))

left = 0
right = n - 1
player1 = 0
player2 = 0
turn = True

while left <= right:
    if cards[left] >= cards[right]:
        picked = cards[left]
        left += 1
    else:
        picked = cards[right]
        right -= 1

    if turn:
        player1 += picked
    else:
        player2 += picked

    turn = not turn

print("Player 1 score:", player1)
print("Player 2 score:", player2)

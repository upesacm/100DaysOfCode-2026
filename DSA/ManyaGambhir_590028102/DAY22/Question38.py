n = int(input())
cards = list(map(int, input().split()))

left = 0
right = n - 1

player1 = 0
player2 = 0
turn = 0

while left <= right:
    if cards[left] >= cards[right]:
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

print(player1, player2)

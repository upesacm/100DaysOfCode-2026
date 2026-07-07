n = int(input())

cards = list(map(int, input().split()))

left = 0
right = n - 1

player1 = 0
player2 = 0

turn = 0

while left <= right:
    if cards[left] >= cards[right]:
        value = cards[left]
        left += 1
    else:
        value = cards[right]
        right -= 1

    if turn == 0:
        player1 += value
    else:
        player2 += value

    turn = 1 - turn

print(player1, player2)
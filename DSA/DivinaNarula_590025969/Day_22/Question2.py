# Card Game Strategy

def card_game(cards):
    left = 0
    right = len(cards) - 1

    player1 = 0
    player2 = 0
    turn = 0  

    while left <= right:

        if cards[left] >= cards[right]:
            chosen = cards[left]
            left += 1
        else:
            chosen = cards[right]
            right -= 1

        if turn == 0:
            player1 += chosen
        else:
            player2 += chosen

        turn = 1 - turn

    return player1, player2


n = int(input("Enter number of cards: "))

print("Enter the card values:")
cards = list(map(int, input().split()))

if len(cards) != n:
    print("Invalid input!")
else:
    p1, p2 = card_game(cards)
    print(p1, p2)
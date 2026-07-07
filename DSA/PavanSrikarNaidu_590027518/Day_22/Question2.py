def cardGame(cards):
    left = 0
    right = len(cards) - 1

    player1 = 0
    player2 = 0

    turn = 1

    while left <= right:
        if cards[left] >= cards[right]:
            pick = cards[left]
            left += 1
        else:
            pick = cards[right]
            right -= 1

        if turn == 1:
            player1 += pick
            turn = 2
        else:
            player2 += pick
            turn = 1

    print(player1, player2)


cards = [4, 1, 2, 10]
cardGame(cards)
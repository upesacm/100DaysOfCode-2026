def cardGame(cards):
    left = 0
    right = len(cards) - 1
    
    score1 = 0
    score2 = 0
    turn = 1
    
    while left <= right:
        if cards[left] >= cards[right]:
            pick = cards[left]
            left += 1
        else:
            pick = cards[right]
            right -= 1
        
        if turn == 1:
            score1 += pick
            turn = 2
        else:
            score2 += pick
            turn = 1
    
    print(score1, score2)
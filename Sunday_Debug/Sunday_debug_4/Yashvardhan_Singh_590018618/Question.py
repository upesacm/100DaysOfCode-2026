def num_boats(weights, limit):
    weights.sort(reverse=True)
    left = 0
    right = len(weights) - 1
    boats = 0
    while left <= right:    #fix
        if weights[left] + weights[right] <= limit:  #fix
            left += 1   #fix
            right -= 1  #fix
        else:
            left += 1   #fix
        boats += 1
    print(boats)    #fix

weights = list(map(int, input().split()))
limit = int(input())
num_boats(weights, limit)

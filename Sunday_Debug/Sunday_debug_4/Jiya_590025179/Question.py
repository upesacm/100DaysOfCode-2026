def num_boats(weights, limit):
    weights.sort(reverse=True)
    left = 0
    right = len(weights) - 1
    boats = 0

    while left <= right:
        if weights[left] + weights[right]<= limit:
            left=left+1
            right=right-1
        else:
            left=left+1
        boats=boats+1
        
    print(boats)

weights = list(map(int, input().split()))
limit = int(input())
num_boats(weights, limit)

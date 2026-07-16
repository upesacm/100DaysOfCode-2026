def num_boats(weights, limit):
    weights.sort(reverse=True)

    left = 0                    
    right = len(weights) - 1   
    boats = 0

    while left <= right:
        if left == right:
            boats += 1
            break

        if weights[left] + weights[right] <= limit:
            left += 1
            right -= 1
        else:
            left += 1

        boats += 1

    print(boats)

weights = list(map(int, input().split()))
limit = int(input())

num_boats(weights, limit)
def num_boats(weights, limit):

    weights.sort(reverse=True)

    left = 0 #heaviest
    right = len(weights) - 1 #lightest
    boats = 0

#Bug if one soilder remain they need one more boat
    while left <= right:
        if left == right:
            boats += 1
            break

        # Bug pair two soldiers only if their total weight is less than or equal to the limit
        if weights[left] + weights[right] <= limit:

            # Bug wrong increment an decremnet of pointers
            left += 1
            right -= 1
        else:
            left += 1

        boats += 1
# bug: should return boats itself as initialized from 0
    print(boats)


weights = list(map(int, input().split()))
limit = int(input())

num_boats(weights, limit)
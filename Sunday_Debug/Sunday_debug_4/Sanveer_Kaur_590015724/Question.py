def num_boats(weights, limit):

    # Sort in descending order
    weights.sort(reverse=True)

    left = 0
    right = len(weights) - 1
    boats = 0

    while left <= right:

        # Only one soldier left
        if left == right:
            boats += 1
            break

        # Pair heaviest and lightest if possible
        if weights[left] + weights[right] <= limit:
            left += 1
            right -= 1
        else:
            # Heaviest goes alone
            left += 1

        boats += 1

    print(boats)


weights = list(map(int, input().split()))
limit = int(input())

num_boats(weights, limit)
def num_boats(weights, limit):

    # Sort in ascending order
    weights.sort()

    left = 0
    right = len(weights) - 1

    boats = 0

    # Continue until everyone gets a boat
    while left <= right:

        # If lightest and heaviest can go together
        if weights[left] + weights[right] <= limit:
            left += 1

        # Heaviest person always gets on a boat
        right -= 1

        # One boat is used
        boats += 1

    print(boats)


weights = list(map(int, input().split()))
limit = int(input())

num_boats(weights, limit)

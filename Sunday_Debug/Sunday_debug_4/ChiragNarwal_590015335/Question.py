def num_boats(weights, limit):
    # Heaviest soldiers first
    weights.sort(reverse=True)

    heavy = 0
    light = len(weights) - 1
    boats = 0

    while heavy <= light:

        # Only one soldier left
        if heavy == light:
            boats += 1
            break

        # Try to pair the heaviest with the lightest
        if weights[heavy] + weights[light] <= limit:
            heavy += 1
            light -= 1
        else:
            # Heaviest soldier goes alone
            heavy += 1

        boats += 1

    print(boats)


weights = list(map(int, input().split()))
limit = int(input())

num_boats(weights, limit)
# Function to calculate the minimum number of boats
def min_boats(weights, limit):
    # Sort the weights in descending order
    weights.sort(reverse=True)

    # Two pointers
    heaviest = 0
    lightest = len(weights) - 1
    boats = 0

    while heaviest <= lightest:
        # Pair the heaviest with the lightest if possible
        if weights[heaviest] + weights[lightest] <= limit:
            lightest -= 1

        # Heaviest soldier always boards a boat
        heaviest += 1
        boats += 1

    return boats

# Driver code
weights = [5, 1, 4, 2]
limit = 6

print("Weights =", weights)
print("Limit =", limit)
print(min_boats(weights, limit))
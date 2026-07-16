def num_boats(weights, limit):
    # Step 1: Sort weights in descending order
    weights.sort(reverse=True)

    # Step 2: Initialize two pointers
    left = 0                      
    right = len(weights) - 1      

    boats = 0

    # Step 3: Continue until all soldiers are assigned to boats
    while left <= right:

        # If only one soldier is left
        if left == right:
            boats += 1
            break

        # If the heaviest and lightest soldiers can share a boat
        if weights[left] + weights[right] <= limit:
            left += 1
            right -= 1
        else:
            # Otherwise, the heaviest soldier goes alone
            left += 1

        # One boat has been used
        boats += 1

    # Step 4: Print the minimum number of boats
    print(boats)



# Input weights
weights = list(map(int, input("Enter soldier weights: ").split()))

# Input boat limit
limit = int(input("Enter boat weight limit: "))

# Function call
num_boats(weights, limit)
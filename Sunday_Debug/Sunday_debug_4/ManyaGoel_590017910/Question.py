def num_boats(weights, limit):
    
    weights.sort(reverse=True)

    left = 0
    right = len(weights) - 1
    boats = 0
    
    
    while left <= right: # FIX 1: Changed '<' to '<=' to process the last remaining soldier.
        
        # FIX 2: Added a check for the last remaining soldier to assign one final boat.
        if left == right:
            boats += 1
            break

        if weights[left] + weights[right] <= limit: # FIX 3: Changed '>=' to '<=' so soldiers are paired only within the weight limit.
            # FIX 4: Moved both pointers inward after successfully pairing two soldiers.
            left += 1
            right -= 1
        else:
            # FIX 5: Moved only the heaviest soldier when pairing is not possible.
            left += 1

        boats += 1
    # FIX 6: Removed '-1' to print the correct boat count.
    print(boats)


weights = list(map(int, input().split()))
limit = int(input())
print("Weights =", weights)
print("Limit =", limit)


num_boats(weights, limit)
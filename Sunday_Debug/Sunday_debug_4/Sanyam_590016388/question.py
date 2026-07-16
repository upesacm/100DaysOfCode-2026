def num_boats(weights, limit):
    # 1. Sort the array of soldier weights in descending order
    weights.sort(reverse=True)

    left = 0
    right = len(weights) - 1
    boats = 0 
    
    # 2. Loop until all soldiers are processed (including the last single soldier)
    while left <= right:
        # If there is only one soldier left, they take their own boat
        if left == right:
            boats += 1
            break
            
        # 3. Check if the heaviest (left) and lightest (right) can share a boat
        if weights[left] + weights[right] <= limit:
            # Both fit, move both pointers inward
            left += 1
            right -= 1
        else:
            # Heaviest soldier is too heavy to pair with the lightest; sends alone
            left += 1

        boats += 1
        
    print(boats)

# Input handling
weights = list(map(int, input().split()))
limit = int(input())
num_boats(weights, limit)
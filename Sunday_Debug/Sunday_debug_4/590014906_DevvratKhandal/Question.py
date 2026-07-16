def num_boats(weights, limit):
    weights.sort()          

    left = 0                
    right = len(weights) - 1 
    boats = 0

    while left <= right:
        if weights[left] + weights[right] <= limit:
            left += 1       

        right -= 1          
        boats += 1

    print(boats)


# Input
weights = list(map(int, input("Enter soldier weights: ").split()))
limit = int(input("Enter boat limit: "))

num_boats(weights, limit)
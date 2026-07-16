
def num_boats(weights, limit):

    weights.sort(reverse=True)

    left = 0
    right = len(weights) - 1
    boats = 0

    while left <= right:    #Ensures the last remaining soldier is counted

        if weights[left] + weights[right] <= limit:       #Two soldiers can share a boat only if their total weight is within the limit
            left +=1     #The left pointer starts at the heaviest soldier so it should move forward
            right -=1    #The right pointer starts at the lightest soldier so it should move backward
        else:
            left+= 1     #If they can't share, the heaviest soldier goes alone so move the left pointer

        boats += 1       #already correct so don't - 1

    print(boats)


weights = list(map(int, input().split()))
limit = int(input())

num_boats(weights, limit)
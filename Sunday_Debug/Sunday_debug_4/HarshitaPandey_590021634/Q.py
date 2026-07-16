#Q4

def num_boats(weights, limit):

    weights.sort(reverse=True)

    left = 0
    right = len(weights) - 1
    boats = 0 

    while left < right:

        if weights[left] + weights[right] > limit:
            left += 1
            right -= 1

        else: 
            right -= 1 

        boats += 1


    print(boats)

weights = list(map(int, input().split()))
limit = int(input())

num_boats(weights, limit) 


"""the issues here were: firstly, the bounds being checked had '>=', that is wrong, it includes the condition of 
the sum being equal to the limit and so the while loop takes that one case into consideration as well.
second error, both pointers are being moved in the wrong direction.
print statement contained boats-1.  """
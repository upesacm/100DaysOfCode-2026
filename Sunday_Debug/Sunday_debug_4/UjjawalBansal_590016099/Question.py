def num_boats(weights, limit):

    weights.sort(reverse=True)

    left = 0
    right = len(weights) - 1
    boats = 0

    # Fix 1 -> Originally the loop checked (left < right) but if after all evacuations, a single soilder remains, this loop will skip that soilder and the count of boat will be 1 less than actually required. So we changed it to (left <= right) so that it checks the last remaining solider too.
    while left <= right:

        # Fix 2 -> Originally the line was (if weights[left] + weights[right] >= limit:). It checked if the combined weight was greater than the limit, but it should be opposite, the combined weight should be less than the limit. Hence the '>=' got changed to '<='
        if weights[left] + weights[right] <= limit:
            # Fix 3 -> Left is starting of the list and right is the end, so after 2 soilders leave, boht should move inwards, but originally they moved outwards (left -= 1) and (right += 1). It will cause Index out of bound error so we changed it to (left += 1) and (right -= 1)
            left += 1
            right -= 1
        else:
            #Fix 4 -> As the list is sorted in descending order, the heaviest soilder is on the leftmost index, after he evacuates, the left pointer should move forward. So we changed (right -= 1) to (left += 1).
            left += 1

        boats += 1

    # Fix 5 -> Now the 'boats' variable contains the exact amount of boat needed, so we don't need to print(boats - 1). Hence we changed it to print(boats).
    print(boats)


weights = list(map(int, input().split()))
limit = int(input())

num_boats(weights, limit)
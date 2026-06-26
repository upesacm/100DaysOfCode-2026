def largest_element(arr,n):
    max = arr[0]
    for i in range(1,n):
        if arr[i] > max:
            max = arr[i]
    return max

m = [8, 3, 15, 2, 10]
print(largest_element(m,len(m)))
def mu(arr,target):
    count = 0
    for i in range(len(arr)):
        if arr[i] == target:
            count = count + 1
    return count        

arr = [1,1,2,2,2,2] 
target = 2
print(mu(arr,target))
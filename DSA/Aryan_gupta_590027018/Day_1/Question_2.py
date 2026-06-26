def sum_array(arr, index=0):
    if index == len(arr):
        return 0
    
    return arr[index] + sum_array(arr, index + 1)
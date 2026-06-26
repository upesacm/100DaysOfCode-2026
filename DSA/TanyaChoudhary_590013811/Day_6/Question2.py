def unionArrays(arr1, arr2):
    result = []
    i = 0
    j = 0
    
    while i < len(arr1) and j < len(arr2):
        if arr1[i] < arr2[j]:
            if len(result) == 0 or result[-1] != arr1[i]:
                result.append(arr1[i])
            i += 1
        elif arr2[j] < arr1[i]:
            if len(result) == 0 or result[-1] != arr2[j]:
                result.append(arr2[j])
            j += 1
        else:                              
            if len(result) == 0 or result[-1] != arr1[i]:
                result.append(arr1[i])
            i += 1
            j += 1
    
    while i < len(arr1):                 
        if result[-1] != arr1[i]:
            result.append(arr1[i])
        i += 1
    
    while j < len(arr2):                  
        if result[-1] != arr2[j]:
            result.append(arr2[j])
        j += 1
    
    return result
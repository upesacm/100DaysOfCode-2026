def strStr(haystack, needle):
    
    if not needle:
        return 0
        

    n_len= len(needle)
    h_len= len(haystack)

    size= h_len - n_len + 1


    for i in range(size):
        
        if (haystack[i: i+ n_len] == needle):
            return i

    else:
        return -1
    


haystack = input("Enter haystack string: ")
needle = input("Enter needle string: ")

result = strStr(haystack, needle)

print(result)

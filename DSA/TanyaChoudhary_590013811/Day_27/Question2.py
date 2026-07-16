def countSubarrays(arr, l, r):
    def countAtMost(arr, limit):
        count = 0
        curr = 0
        for num in arr:
            if num <= limit:
                curr += 1
            else:
                curr = 0
            count += curr
        return count
    
    return countAtMost(arr, r) - countAtMost(arr, l - 1)
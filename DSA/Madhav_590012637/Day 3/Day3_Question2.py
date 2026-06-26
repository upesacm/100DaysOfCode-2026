class Solution:
    
    def countFreq(self, arr, target):
        first = self.firstOccurrence(arr, target)
        
        if first == -1:
            return 0
        
        last = self.lastOccurrence(arr, target)
        
        return last - first + 1

    def firstOccurrence(self, arr, target):
        low, high = 0, len(arr) - 1
        ans = -1

        while low <= high:
            mid = (low + high) // 2

            if arr[mid] == target:
                ans = mid
                high = mid - 1
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return ans

    def lastOccurrence(self, arr, target):
        low, high = 0, len(arr) - 1
        ans = -1

        while low <= high:
            mid = (low + high) // 2

            if arr[mid] == target:
                ans = mid
                low = mid + 1
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return ans
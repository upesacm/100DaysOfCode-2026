def count(self, nums, target):
        def firstoccurrence():
            left, right = 0, len(nums) - 1
            first = -1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    first = mid
                    right = mid - 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
                    return first
        def lastoccurrence():
            left, right = 0, len(nums) - 1
            last = -1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    last = mid
                    left = mid + 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
                    return last
        first = firstoccurrence()
        if first == -1:
            return 0
        last = lastoccurrence()
        return last - first + 1
nums = [1,2,3,3,3,4]
target = 3
result = count(nums,target)
print("Occurrences =",result)
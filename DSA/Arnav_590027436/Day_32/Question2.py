def check_target(arr, t):
    left = 0
    right = len(arr) - 1

    while left < right:
        current_sum = arr[left] + arr[right]
        if current_sum == t:
            return True
        elif current_sum < t:
            left += 1
        else:
            right -= 1

        return False
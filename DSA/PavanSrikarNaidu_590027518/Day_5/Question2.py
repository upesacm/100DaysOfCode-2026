class Solution:
    def arraysEqual(self, arr1, arr2):
        if len(arr1) != len(arr2):
            return False

        for i in range(len(arr1)):
            if arr1[i] != arr2[i]:
                return False

        return True


# 🔽 VS Code testing
if __name__ == "__main__":
    s = Solution()

    arr1 = [1, 2, 34]
    arr2 = [4, 3, 2, 1]

    print(s.arraysEqual(arr1, arr2))  # False
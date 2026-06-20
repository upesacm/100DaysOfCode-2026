class Solution:
    def unionArray(self, arr1, arr2):
        return sorted(list(set(arr1 + arr2)))


# VS Code Testing
if __name__ == "__main__":
    arr1 = [1, 2]
    arr2 = [2, 3]

    sol = Solution()
    print(sol.unionArray(arr1, arr2))
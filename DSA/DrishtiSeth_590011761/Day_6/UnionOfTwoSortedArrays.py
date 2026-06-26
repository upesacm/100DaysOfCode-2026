class Solution:
    def findUnion(self, a, b):
        i, j = 0, 0
        ans = []

        while i < len(a) and j < len(b):
            if a[i] <= b[j]:
                if not ans or ans[-1] != a[i]:
                    ans.append(a[i])
                i += 1
            else:
                if not ans or ans[-1] != b[j]:
                    ans.append(b[j])
                j += 1

        while i < len(a):
            if not ans or ans[-1] != a[i]:
                ans.append(a[i])
            i += 1

        while j < len(b):
            if not ans or ans[-1] != b[j]:
                ans.append(b[j])
            j += 1

        return ans

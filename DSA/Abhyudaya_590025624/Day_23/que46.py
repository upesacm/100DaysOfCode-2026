class Solution(object):
    def backspaceCompare(self, s, t):
        def process(string):
            arr = list(string)
            i = 0
            while i < len(arr) - 1:
                if arr[i + 1] == '#':
                    arr[i] = ''
                    arr[i + 1] = ''
                    i += 2
                else:
                    i += 1
            return ''.join(arr).replace('#', '')
        return process(s) == process(t)
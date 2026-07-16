class Solution:
    def backspaceCompare(self, s, t):
        def process(string):
            result = []
            for c in string:
                if c == '#':
                    if result:
                        result.pop()
                else:
                    result.append(c)
            return result
        
        return process(s) == process(t)
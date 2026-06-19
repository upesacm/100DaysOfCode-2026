class Solution(object):
    def transpose(self, matrix):
        return list(map(list,zip(*matrix)))
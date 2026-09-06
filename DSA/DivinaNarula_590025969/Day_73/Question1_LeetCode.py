# Find Closest Node to Given Two Nodes

class Solution(object):
    def getDistance(self, edges, start):
        n = len(edges)
        dist = [-1] * n
        d = 0
        node = start

        while node != -1 and dist[node] == -1:
            dist[node] = d
            d += 1
            node = edges[node]

        return dist

    def closestMeetingNode(self, edges, node1, node2):
        dist1 = self.getDistance(edges, node1)
        dist2 = self.getDistance(edges, node2)

        answer = -1
        minDist = float('inf')

        for i in range(len(edges)):
            if dist1[i] != -1 and dist2[i] != -1:
                curr = max(dist1[i], dist2[i])
                if curr < minDist:
                    minDist = curr
                    answer = i

        return answer
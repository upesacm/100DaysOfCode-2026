class Solution:
    def closestMeetingNode(self, edges, node1, node2):
        n = len(edges)

        def get_dist(start):
            dist = [-1] * n
            current = start
            d = 0

            while current != -1 and dist[current] == -1:
                dist[current] = d
                d += 1
                current = edges[current]

            return dist

        dist1 = get_dist(node1)
        dist2 = get_dist(node2)

        answer = -1
        best = float("inf")

        for i in range(n):
            if dist1[i] != -1 and dist2[i] != -1:
                maximum = max(dist1[i], dist2[i])

                if maximum < best:
                    best = maximum
                    answer = i

        return answer
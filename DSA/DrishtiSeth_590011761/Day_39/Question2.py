import heapq

def minMeetingRooms(intervals):
    if not intervals:
        return 0

    intervals.sort(key=lambda x: x[0])

    heap = [intervals[0][1]]

    for start, end in intervals[1:]:
        if start >= heap[0]:
            heapq.heappop(heap)

        heapq.heappush(heap, end)

    return len(heap)

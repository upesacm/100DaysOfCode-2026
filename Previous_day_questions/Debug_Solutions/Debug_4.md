<h2 align="center">Week 4 Day 28 (12/07/2026) — Weekly Debug 4</h2>

## 1. Dhurandhar - The Last Rescue

### Solution

```python
def num_boats(weights, limit):
    weights.sort(reverse=True)
    left = 0
    right = len(weights) - 1
    boats = 0
    # BUG: Loop ended before the middle soldier was placed on a boat.
    while left <= right:
        # BUG: Pairing condition was inverted.
        if weights[left] + weights[right] <= limit:
            # BUG: Pointers moved outward instead of inward.
            left += 1
            right -= 1
        else:
            # BUG: Wrong pointer was moved when a pair didn't fit.
            left += 1
        boats += 1
    # BUG: Final boat count was off by one.
    print(boats)

weights = list(map(int, input().split()))
limit = int(input())
num_boats(weights, limit)
```

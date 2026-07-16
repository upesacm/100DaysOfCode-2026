<h2 align="center">Week 4 Day 28 (12/07/2026) — Weekly Debug 4</h2>

## 1. Dhurandhar - The Last Rescue

After a fierce battle, the legendary warrior Dhurandhar must rescue every surviving soldier before enemy forces surround the valley. A limited number of rescue boats are available, and each boat can carry at most two soldiers without exceeding its maximum weight limit.

The rescue system was designed using the Two Pointer technique to pair the lightest and heaviest soldiers whenever possible, minimizing the total number of boats required.

Just before the evacuation began, an enemy spy sabotaged the rescue program. The code still executes, but soldiers are paired incorrectly, extra boats are used, and in some situations the pointers move in the wrong direction, leading to an incorrect rescue count.

Dhurandhar has a few minutes before enemy forces surround the valley. The rescue program is broken. The soldiers can't be evacuated.

Fix the rescue program before the enemy arrives.

This problem is commonly asked in interviews and helps build concepts like:
- Two pointer technique
- Greedy algorithm
- Sorting
- Boat pairing simulation

which are important for writing correct and reliable programs.

**Your task:** Identify and fix all bugs in the given code so that it produces the correct output.

### What the Code Must Do

- Sort the array of soldier weights in descending order.
- Use the Two Pointer technique with one pointer at the lightest soldier and the other at the heaviest soldier.
- If the combined weight of the two soldiers is within the boat limit, place them in the same boat.
- Otherwise, send the heaviest soldier alone.
- Count the minimum number of boats required to rescue all soldiers.
- Print the minimum number of boats needed.

### Constraints

- 1 <= number of soldiers <= 10^5
- 1 <= weights[i] <= 10^5
- 1 <= limit <= 10^5
- Each boat can carry at most two soldiers
- Correct the existing implementation. Do not rewrite using another data structure.

### Examples

**Input:**
```
weights = [5, 1, 4, 2]
limit = 6
```
**Output:**
```
2
```

### Buggy Code

```python
def num_boats(weights, limit):
    weights.sort(reverse=True)
    left = 0
    right = len(weights) - 1
    boats = 0
    while left < right:
        if weights[left] + weights[right] >= limit:
            left -= 1
            right += 1
        else:
            right -= 1
        boats += 1
    print(boats - 1)

weights = list(map(int, input().split()))
limit = int(input())
num_boats(weights, limit)
```

<h2 align="center">Week 6 Day 36 (20/07/2026)</h2>

## 1. Implement Stack using Queues (LeetCode #225)
A problem that teaches how to simulate one data structure using another by implementing a last-in-first-out (LIFO) stack using only two queues.
The implemented stack should support all the functions of a normal stack: push, top, pop, and empty. You must use only standard queue operations, meaning only push to back, peek/pop from front, size, and is-empty operations are valid. Depending on the language, the queue may not be supported natively; it may be simulated using a list or deque as long as only standard queue operations are used.
This problem is commonly asked in interviews and helps build concepts like:
- queue operations
- data structure simulation
which are important for efficient stack based problems.
**Your task:** Implement the MyStack class with push, pop, top, and empty operations, using only two queues internally.
### Constraints
- 1 <= x <= 9
- At most 100 calls will be made to push, pop, top, and empty.
- All the calls to pop and top are valid.
### Examples
**Input:**
```
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
```
**Output:**
```
[null, null, null, 2, 2, false]
```
---
## 2. Ticket Counter Queue
A queue simulation problem that requires tracking the position of a specific person while the queue changes over time. There are n people standing in a queue at a ticket counter, numbered from 1 to n, where person 1 is at the front and person n is at the back. The counter serves exactly one person every minute. After a person is served, the following rule is applied: if the next person at the front of the queue has an odd numbered ticket, they leave the front and move to the back of the queue. Otherwise, they remain in place and are served normally. This process continues until everyone receives their ticket.
This problem is commonly asked in interviews and helps build concepts like:
- queue simulation
- position tracking
which are important for efficient queue based simulation problems.
**Your task:** Given n and a target person k, determine the minute at which person k receives their ticket.
### Constraints
- 1 <= n <= 500
- 1 <= k <= n
### Examples
**Input:**
```
n = 4
k = 3
```
**Output:**
```
4
```
---
**Input:**
```
n = 3
k = 1
```
**Output:**
```
1
```
---
**Input:**
```
n = 5
k = 4
```
**Output:**
```
3
```
---

from collections import deque

class FrontMiddleBackQueue:

    def __init__(self):
        self.left = deque()
        self.right = deque()

    def balance(self):
        if len(self.left) > len(self.right):
            self.right.appendleft(self.left.pop())
        elif len(self.right) > len(self.left) + 1:
            self.left.append(self.right.popleft())

    def pushFront(self, val: int) -> None:
        self.left.appendleft(val)
        self.balance()

    def pushMiddle(self, val: int) -> None:
        if len(self.left) == len(self.right):
            self.right.appendleft(val)
        else:
            self.left.append(val)
        self.balance()

    def pushBack(self, val: int) -> None:
        self.right.append(val)
        self.balance()

    def popFront(self) -> int:
        if not self.left and not self.right:
            return -1

        if self.left:
            ans = self.left.popleft()
        else:
            ans = self.right.popleft()

        self.balance()
        return ans

    def popMiddle(self) -> int:
        if not self.left and not self.right:
            return -1

        if len(self.left) == len(self.right):
            ans = self.left.pop()
        else:
            ans = self.right.popleft()

        self.balance()
        return ans

    def popBack(self) -> int:
        if not self.left and not self.right:
            return -1

        if self.right:
            ans = self.right.pop()
        else:
            ans = self.left.pop()

        self.balance()
        return ans

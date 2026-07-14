class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedListStack:
    def __init__(self):
        self.top = None
        self._size = 0

    def push(self, data):
        node = Node(data)
        node.next = self.top
        self.top = node
        self._size += 1

    def pop(self):
        if self.is_empty():
            raise IndexError("pop from empty stack")
        node = self.top
        self.top = self.top.next
        self._size -= 1
        return node.data

    def peek(self):
        if self.is_empty():
            raise IndexError("peek from empty stack")
        return self.top.data

    def is_empty(self):
        return self.top is None

    def size(self):
        return self._size


def next_greater_elements(arr):
    n = len(arr)
    result = [-1] * n
    stack = LinkedListStack() 

    for i in range(n):
        while not stack.is_empty() and arr[stack.peek()] < arr[i]:
            idx = stack.pop()
            result[idx] = arr[i]
        stack.push(i)

    return result

n = int(input("Enter the number of elements in the array: "))
arr = []
for i in range(n):
    element = int(input(f"Enter element {i + 1}: "))
    arr.append(element)

print(next_greater_elements(arr))
# Maximum XOR Pair

class TrieNode:
    def __init__(self):
        self.child = [None, None]


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, num):
        node = self.root
        for i in range(31, -1, -1):
            bit = (num >> i) & 1
            if node.child[bit] is None:
                node.child[bit] = TrieNode()
            node = node.child[bit]

    def get_max_xor(self, num):
        node = self.root
        xor_value = 0

        for i in range(31, -1, -1):
            bit = (num >> i) & 1
            opposite = 1 - bit

            if node.child[opposite]:
                xor_value |= (1 << i)
                node = node.child[opposite]
            else:
                node = node.child[bit]

        return xor_value


def maximum_xor_pair(arr):
    trie = Trie()

    for num in arr:
        trie.insert(num)

    maximum = 0

    for num in arr:
        maximum = max(maximum, trie.get_max_xor(num))

    return maximum


n = int(input("Enter the number of elements: "))
arr = list(map(int, input("Enter the elements: ").split()))

print("Maximum XOR Pair:", maximum_xor_pair(arr))
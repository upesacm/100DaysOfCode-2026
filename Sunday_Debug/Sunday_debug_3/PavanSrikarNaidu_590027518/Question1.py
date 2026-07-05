class Node:
    def __init__(self, heroID):
        self.heroID = heroID
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    # Insert at end
    def insert(self, heroID):
        new_node = Node(heroID)

        if self.head is None:
            self.head = new_node
            return

        temp = self.head
        while temp.next:
            temp = temp.next

        temp.next = new_node

    # Display list
    def display(self):
        temp = self.head

        while temp:
            print(temp.heroID, end=" -> ")
            temp = temp.next

        print("NULL")

    # Delete a hero
    def deleteHero(self, heroID):
        temp = self.head
        prev = None

        while temp and temp.heroID != heroID:
            prev = temp
            temp = temp.next

        if temp is None:
            return

        if prev is None:
            self.head = self.head.next
        else:
            prev.next = temp.next

    # Find middle hero
    def findMiddle(self):
        slow = self.head
        fast = self.head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        return slow


# Driver Code
heroes = LinkedList()

heroes.insert(1)
heroes.insert(2)
heroes.insert(3)
heroes.insert(4)
heroes.insert(5)

heroes.display()

heroes.deleteHero(3)

heroes.display()

middle = heroes.findMiddle()

if middle:
    print("Backup Leader:", middle.heroID)
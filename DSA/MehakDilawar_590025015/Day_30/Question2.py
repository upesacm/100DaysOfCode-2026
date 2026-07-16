#Given a stack of integers and an integer x, insert x at the bottom of the stack while preserving the order 
# of the remaining elements, and print the updated stack.
#Input:Stack = [1,2,3,4], x = 5. Output:[5,1,2,3,4]
def insert_at_bottom(stack, x):
    if not stack:
        stack.append(x)
        return
    top = stack.pop()
    insert_at_bottom(stack, x)
    stack.append(top)
stack = list(map(int, input("Enter stack elements: ").split()))
x = int(input("Enter element to insert at bottom: "))
insert_at_bottom(stack, x)
print("Updated Stack:", stack)
public Stack<Integer> insertAtBottomIterative(Stack<Integer> stack, int x) {
    Stack<Integer> temp = new Stack<>();
    while (!stack.isEmpty()) {
        temp.push(stack.pop());
    }
    stack.push(x);
    while (!temp.isEmpty()) {
        stack.push(temp.pop());
    }
    return stack;
}

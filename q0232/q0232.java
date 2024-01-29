class MyQueue {

    // elements are added to stack1 to ensure the order of processing
    private Stack<Integer> stack1;
    // elements are peeked / popped from stack2 to ensure dequeue ordering
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        // Since elements are removed from only stack2, stack2 needs to be populated
        // With elements stored in stack1 (only if necessary)
        transferFromS1ToS2();
        return stack2.pop();
    }

    public int peek() {
        // Since elements are removed from only stack2, stack2 needs to be populated
        // With elements stored in stack1 (only if necessary)
        transferFromS1ToS2();
        return stack2.peek();
    }

    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }

    // Make transfer from stack1 to stack2 only when stack2 is empty
    private void transferFromS1ToS2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
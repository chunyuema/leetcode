class MyStack {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    public MyStack() {
    }
    
    // push is heavy operation with O(n) the idea is to push the new element to the front of q2, then transfer all the elements from q1 to q2 such that the newly added elements will be at the beginning of the q.
    public void push(int x) {
        q2.add(x);
        top = x;
        while (!q1.isEmpty()) q2.add(q1.remove());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        int res = q1.remove();
        if (!q1.isEmpty()) top = q1.peek();
        return res;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
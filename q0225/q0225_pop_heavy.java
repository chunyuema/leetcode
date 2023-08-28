class MyStack {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    public MyStack() {
    }
    
    public void push(int x) {
        q1.add(x);
        top = x;
    }
    
    // pop operation will take O(n) as we need to transfer the elements from q1 to q2
    public int pop() {
        while (q1.size() > 1 ) {
            top = q1.remove();
            q2.add(top);
        }
        int res = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return res;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
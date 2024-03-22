class MinStack {
    private Deque<int[]> elements;
    private int currMin;

    public MinStack() {
        elements = new ArrayDeque<int[]>();
        currMin = Integer.MAX_VALUE;
    }

    public void push(int val) {
        elements.push(new int[] { val, currMin });
        currMin = Math.min(currMin, val);
    }

    public void pop() {
        int[] pair = elements.pop();
        currMin = pair[1];
    }

    public int top() {
        return elements.peek()[0];
    }

    public int getMin() {
        return currMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
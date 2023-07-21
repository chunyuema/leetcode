class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int a : asteroids) {
            boolean isAsteroidAlive = true;
            while (!stack.isEmpty() && (stack.peek() > 0 && a < 0)) {
                if (Math.abs(stack.peek()) < Math.abs(a)) {
                    stack.pop();
                    continue;
                } else {
                    isAsteroidAlive = false;
                    if (Math.abs(stack.peek()) == Math.abs(a))
                        stack.pop();
                    break;
                }
            }
            if (isAsteroidAlive)
                stack.push(a);
        }

        return getArray(stack);
    }

    private int[] getArray(Deque<Integer> deque) {
        int[] arr = new int[deque.size()];
        for (int i = deque.size() - 1; i >= 0; i--) {
            arr[i] = deque.pop();
        }
        return arr;
    }
}

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        int farthest = x + a + b;

        // Initialize the queue
        Deque<State> queue = new ArrayDeque<>();
        queue.offer(new State(0, true));

        // Initialize the visited / prohibited area
        Set<State> visitedOrProhibited = new HashSet<>();
        // visitedOrProhibited.add(new State(0, true));
        for (int f : forbidden) {
            farthest = Math.max(f + a + b, farthest);
            visitedOrProhibited.add(new State(f, true));
            visitedOrProhibited.add(new State(f, false));
        }

        // Perform BFS
        int jumps = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                final State state = queue.poll();
                // System.out.println("Current State: " + state);

                int pos = state.pos;

                // Check if we are already at the end
                if (pos == x) return jumps;

                // Jump forward
                final State forwardState = new State(pos + a, true);
                if (forwardState.pos <= farthest && 
                    !visitedOrProhibited.contains(forwardState)) {
                        queue.offer(forwardState);
                        visitedOrProhibited.add(forwardState);
                        // System.out.println("Adding forward state: " + forwardState);
                }

                // Jump backward
                final State backwardState = new State(pos - b, false);
                if (backwardState.pos >= 0 &&
                    !visitedOrProhibited.contains(backwardState) &&
                    state.forward) {
                        queue.offer(backwardState);
                        visitedOrProhibited.add(backwardState);
                        // System.out.println("Adding backward state: " + backwardState);
                }
            }
            jumps++;
        }
        return -1;
    }

    private class State {
        int pos; 
        boolean forward;

        public State(int pos, boolean forward) {
            this.pos = pos;
            this.forward = forward;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }

            if (other == null || this.getClass() != other.getClass()) {
                return false;
            }

            State state = (State) other;

            return this.pos == state.pos && this.forward == state.forward;
        }

        public int hashCode() {
            return Objects.hash(pos, forward);
        }

        public String toString() {
            return pos + " : " + forward;
        }
    }
}
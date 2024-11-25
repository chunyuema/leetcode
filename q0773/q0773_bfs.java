class Solution {
    private int[][] directions = new int[][] {
            { 1, 3 },
            { 0, 2, 4 },
            { 1, 5 },
            { 0, 4 },
            { 1, 3, 5 },
            { 2, 4 }};
    
    // Main BFS Function To Find the shortest move to target state
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String target = "123450";
        Set<String> visited = new HashSet<>();
        visited.add(start);

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        
        int minMoves = 0; 
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) return minMoves;

                // Find the posiion of zero
                int currZeroPos = curr.indexOf('0');

                // Explore all the next possible states
                for (int nextZeroPos : directions[currZeroPos]) {
                    String next = updateState(curr, currZeroPos, nextZeroPos);
                    // If we have already visited this state
                    if (visited.contains(next)) continue;
                    // If we have not visited this state, add to queue for BFS
                    queue.add(next);
                    visited.add(next);
                }
            }
            minMoves++;
        }
        return -1;
    }

    private String updateState(String curr, int currZeroPos, int nextZeroPos) {
        StringBuilder sb = new StringBuilder(curr);
        sb.setCharAt(currZeroPos, curr.charAt(nextZeroPos));
        sb.setCharAt(nextZeroPos, curr.charAt(currZeroPos));
        return sb.toString();
    }
}
package q1970;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 1;
        int r = row * col;

        // Use binary search to look for the latest day
        while (l < r) {
            int m = r - (r - l) / 2;
            if (canCross(row, col, m, cells)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private boolean canCross(int row, int col, int day, int[][] cells) {

        // Initialize the graph on which BFS will be performed
        int[][] currGrid = new int[row][col];
        for (int i = 0; i < day; i++) {
            int[] floodedCell = cells[i];
            currGrid[floodedCell[0] - 1][floodedCell[1] - 1] = 1;
        }

        // Initialize the queue to be used for BFS
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < col; i++) {
            // On the first row, all cells that are not currently flooed can be used as a starting point for the BFS
            if (currGrid[0][i] != 1) {
                queue.add(new int[] { 0, i });
                currGrid[0][i] = -1;
            }
        }

        int[][] moves = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int[] currLoc = queue.poll();
            int currRow = currLoc[0];
            int currCol = currLoc[1];

            // If currRow == row - 1, that means we have successfully crossed the river
            if (currRow == row - 1) return true;

            // Given a cell, perform BFS to check the possible next cell to be added to the BFS 
            for (int[] move : moves) {
                int nextRow = currRow + move[0];
                int nextCol = currCol + move[1];
                int[] nextLoc = new int[] { nextRow, nextCol };
                if (nextRow >= 0 && nextRow < row &&
                    nextCol >= 0 && nextCol < col &&
                    currGrid[nextRow][nextCol] == 0) {
                    queue.add(nextLoc);
                    currGrid[nextRow][nextCol] = -1;
                }
            }
        }
        return false;
    }
}
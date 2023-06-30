package q0864;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        Set<Character> keySet = new HashSet<>();
        Set<Character> lockSet = new HashSet<>();
        int startCol = -1;
        int startRow = -1;
        int keyState = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                // determine if c is a key
                if (c >= 'a' && c <= 'f') {
                    keyState += (1 << (c - 'a'));
                    keySet.add(c);
                }
                // determine if c is a lock
                if (c >= 'A' && c <= 'F') {
                    lockSet.add(c);
                }
                // determine starting position
                if (c == '@') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        Map<Integer, Set<Pair<Integer, Integer>>> visited = new HashMap<>();
        int initialKeyState = 0;
        visited.put(initialKeyState, new HashSet<>());
        visited.get(initialKeyState).add(new Pair<>(startRow, startCol));

        int[][] moves = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startRow, startCol, initialKeyState, 0 });
        while (!queue.isEmpty()) {
            int[] currentState = queue.poll();
            int currRow = currentState[0];
            int currCol = currentState[1];
            int currKeyState = currentState[2];
            int currPath = currentState[3];
            for (int[] move : moves) {
                int newRow = currRow + move[0];
                int newCol = currCol + move[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow].charAt(newCol) != '#') {
                    char c = grid[newRow].charAt(newCol);

                    if (keySet.contains(c)) {
                        if (((1 << (c - 'a')) & currKeyState) != 0)
                            continue;
                        int newKeyState = (currKeyState | (1 << (c - 'a')));
                        if (newKeyState == keyState)
                            return currPath + 1;
                        visited.putIfAbsent(newKeyState, new HashSet<>());
                        visited.get(newKeyState).add(new Pair<>(newRow, newCol));
                        queue.add(new int[] { newRow, newCol, newKeyState, currPath + 1 });
                    }

                    if (lockSet.contains(c) && ((currKeyState & (1 << (c - 'A'))) == 0)) {
                        continue;
                    }

                    if (!visited.get(currKeyState).contains(new Pair<>(newRow, newCol))) {
                        visited.get(currKeyState).add(new Pair<>(newRow, newCol));
                        queue.add(new int[] { newRow, newCol, currKeyState, currPath + 1 });
                    }
                }
            }
        }
        return -1;
    }
}

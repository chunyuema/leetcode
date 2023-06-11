import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preReqMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preReqMap.put(i, new ArrayList<Integer>());
        }
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int preReq = pair[1];
            preReqMap.get(course).add(preReq);

        }
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfsCheckCycle(visited, preReqMap, i))
                return false;
        }
        return true;
    }

    private boolean dfsCheckCycle(HashSet<Integer> visited,
            Map<Integer, List<Integer>> preReqMap,
            int c) {
        if (visited.contains(c))
            return false;
        if (preReqMap.get(c).size() == 0)
            return true;
        visited.add(c);
        for (int preReq : preReqMap.get(c)) {
            if (!dfsCheckCycle(visited, preReqMap, preReq))
                return false;
        }
        visited.remove(c);
        preReqMap.get(c).clear();
        return true;
    }
}
package q1601;

class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] buildingBalanced = new int[n];
        return maxReqHelper(buildingBalanced, requests, 0, 0);
    }

    private int maxReqHelper(int[] buildingBalanced, int[][] request, int requetIndex, int maxReqSatisfied) {

        // base case: if there is not more request to satisfy, check if the netflow of
        // people satisfy the condition
        // No two people should be in the same building => all entries of
        // buildingBalanced = 0
        if (requetIndex == request.length) {
            for (int b : buildingBalanced) {
                if (b != 0)
                    return 0;
            }
            return maxReqSatisfied;
        }
        ;

        // consider the current request
        int srcBuilding = request[requetIndex][0];
        int dstBuilding = request[requetIndex][1];

        // satisfy the request, recursively compute the rest
        buildingBalanced[srcBuilding]--;
        buildingBalanced[dstBuilding]++;
        int ans1 = maxReqHelper(buildingBalanced, request, requetIndex + 1, maxReqSatisfied + 1);

        // backtrack and do not satisfy the request, recursively compute the res
        buildingBalanced[srcBuilding]++;
        buildingBalanced[dstBuilding]--;
        int ans2 = maxReqHelper(buildingBalanced, request, requetIndex + 1, maxReqSatisfied);

        return Math.max(ans1, ans2);
    }
}
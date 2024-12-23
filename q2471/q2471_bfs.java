class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int minSwapCount = 0;
        while (!queue.isEmpty()) {
            int[] currLevel = new int[queue.size()];
            for (int i = 0; i < currLevel.length; i++) {
                TreeNode currNode = queue.poll();
                currLevel[i] = currNode.val;

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
            // Update the minimum count
            minSwapCount += countSwaps(currLevel);
        }
        return minSwapCount;
    }

    // Return the min number of swaps required to sort an array
    private int countSwaps(int[] curr) {
        int swaps = 0; 
        int[] target = curr.clone();
        Arrays.sort(target);

        Map<Integer, Integer> currPositions = new HashMap<>();
        for (int i = 0; i < curr.length; i++) currPositions.put(curr[i], i);

        for (int i = 0; i < curr.length; i++) {
            int currNum = curr[i]; 
            int targetNum = target[i];
            // We need to make one swap when it is not equal
            if (currNum != targetNum) {
                // Increment the number of swaps
                swaps++;

                // Get the current position of the targetNum 
                int currPosOfTarget = currPositions.get(targetNum);

                // Swap: Move the currNum to the curr position of targetNum
                currPositions.put(currNum, currPosOfTarget);
                curr[currPosOfTarget] = currNum;

                // Swap: Move the targetNum to the curr position of currNum (not needed)
                // currPositions.put(targetNum, i);
                // curr[i] = targetNum;
            }
        }
        return swaps;
    }
}

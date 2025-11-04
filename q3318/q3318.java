class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int currNum = nums[i];

            // Expand the window
            count.put(currNum, count.getOrDefault(currNum, 0) + 1);

            // Shrink winow
            if (i >= k) {
                int oldNum = nums[i - k];
                int freq = count.get(oldNum) - 1;
                if (freq == 0) count.remove(oldNum);
                else count.put(oldNum, freq);
            }

            // Compute xSum
            if (i + 1 >= k) {
                List<int[]> items = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                    items.add(new int[] {entry.getValue(), entry.getKey()});
                }
                items.sort((a, b) -> b[0] != a[0] ? b[0] - a[0] : b[1] - a[1]);
                int xSum = 0;
                for (int j = 0; j < x && j < items.size(); j++) {
                    xSum += items.get(j)[0] * items.get(j)[1];
                }
                ans[i - k + 1] = xSum;
            }
        }
        return ans;
    }
}

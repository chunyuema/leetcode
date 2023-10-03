class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                // current num can form a good pair with all the
                // previously occurred number
                int prevFrequency = map.get(num);
                res += prevFrequency;
                map.put(num, prevFrequency + 1);
            } else {
                map.put(num, 1);
            }
        }
        return res;
    }
}
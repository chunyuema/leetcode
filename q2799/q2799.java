class Solution {
    public int countCompleteSubarrays(int[] nums) {
        // Get the total unique numbers
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int unique = set.size();

        int count = 0; 
        int r = 0;
        Map<Integer, Integer> curr = new HashMap<>();
        for (int l = 0; l < nums.length; l++) {
            // Remove the element from index l - 1
            // to consider all subarrays starting from l
            if (l > 0) {
                int remove = nums[l - 1];
                curr.put(remove, curr.get(remove) - 1);
                if (curr.get(remove) == 0) curr.remove(remove);
            }

            // Expand the window until condition is met
            while (r < nums.length && curr.size() < unique) {
                int num = nums[r];
                curr.put(num, curr.getOrDefault(num, 0) + 1);
                r++;
            }

            // If condition is met, then [l, r), [l, r+1), ... [l, n)
            // Are all possible subarrays to be added to the answer
            if (curr.size() == unique) {
                count += (nums.length - r + 1);
            }
        }

        return count;
    }
}



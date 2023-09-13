class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // get the next great elements of nums2 into a map
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // build the monotonic increasing stack through looping forward
        for (int currNum : nums2) {
            // currNum will the next greater element for all the elements on the stack that
            // is currently smaller than it
            while (!stack.isEmpty() && currNum > stack.peek()) {
                int prevNum = stack.pop();
                map.put(prevNum, currNum);
            }
            stack.push(currNum);
        }

        // collect the results from the map
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public int[] nextGreaterElementBackward(int[] nums1, int[] nums2) {
        // get the next great elements of nums2 into a map
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // build the monotic stack through looping backwards
        for (int i = nums2.length - 1; i >= 0; i--) {
            int currNum = nums2[i];
            while (!stack.isEmpty() && currNum > stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                map.put(currNum, stack.peek());
            }
            stack.push(currNum);
        }

        // collect the results from the map
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}

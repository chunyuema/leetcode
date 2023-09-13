class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // get the next great elements of nums2 into a map
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // build the monotic decreasing stack through looping backwards
        for (int i = nums2.length - 1; i >= 0; i--) {
            int currNum = nums2[i];

            // keep the nature of the stack by popping all elements that are smaller than
            // currNum
            while (!stack.isEmpty() && currNum > stack.peek()) {
                stack.pop();
            }

            // if there are still any number on the stack, then the top of the stack is the
            // next greater element for the currNum
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

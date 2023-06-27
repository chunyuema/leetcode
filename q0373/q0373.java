package q0373;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<List<Integer>> onHeap = new HashSet<>();
        minHeap.add(new int[] { nums1[0] + nums2[0], 0, 0 });

        while (k > 0 && !minHeap.isEmpty()) {

            // Obtain the min sum pair from the heap, and record them accordingly
            int[] minPair = minHeap.poll();
            int i = minPair[1];
            int j = minPair[2];
            res.add(List.of(nums1[i], nums2[j]));
            k--;

            // Explore the next possible pair (i+1, j)
            List<Integer> nextPair1 = List.of(i + 1, j);
            if (i + 1 < nums1.length && !onHeap.contains(nextPair1)) {
                minHeap.add(new int[] { nums1[i + 1] + nums2[j], i + 1, j });
                onHeap.add(nextPair1);
            }

            // Explore the next possible pair (i, j+1)
            List<Integer> nextPair2 = List.of(i, j + 1);
            if (j + 1 < nums2.length && !onHeap.contains(nextPair2)) {
                minHeap.add(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
                onHeap.add(nextPair2);
            }

        }
        return res;
    }
}
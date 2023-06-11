class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for (int num : nums){
            pq.add(num);
        }

        while (k > 0){
            int smallest = pq.poll();
            pq.add(-1 * smallest);
            k--;
        }

        int sum = 0;
        while (!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;
    }
}
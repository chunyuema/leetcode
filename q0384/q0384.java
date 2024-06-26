class Solution {

    private int[] original;
    private int[] shuffled;
    private Random random = new Random();

    public Solution(int[] nums) {
        shuffled = nums; 
        original = shuffled.clone();
    }
    
    public int[] reset() {
        shuffled = original; 
        original = original.clone(); 
        return shuffled;
    }
    
    public int[] shuffle() {
        for (int i = shuffled.length - 1; i >= 0; i--) {
            int j = 0 + random.nextInt(0, i+1);
            int tmp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = tmp;
        }
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
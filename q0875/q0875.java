class Solution {
    public int minEatingSpeed(int[] piles, int h) {        
        // At least eat 1 banana per hour
        int l = 1;
        // There is no need to eat more than largest pile per hour
        int r = 0;
        for (int pile : piles) r = Math.max(r, pile);
        
        // Binary search to find the minimum eating speed
        while (l < r) {
            int m = l + (r - l) / 2;
            // If Koko can finish within h hours with eating speed m, try slower speeds
            if (canKokoFinishEating(m, h, piles)) {
                r = m;
            } else {
                // If Koko cannot finish within h hours, try faster speeds
                l = m + 1;
            }
        }
        
        return l;
    }
    
    
    private boolean canKokoFinishEating(final int k, final int h, final int[] piles) {
        int timeNeeded = 0;
        for (int pile : piles) {
            // Calculate time needed to eat each pile with eating speed k
            timeNeeded += Math.ceil((double) pile / (double) k);
        }
        // Check if total time needed is <= h hours
        return timeNeeded <= h;
    }
}

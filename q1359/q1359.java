class Solution {
    public int countOrders(int n) {
        int mod = 1000000007;
        long count = 1; 
        int slots = n * 2; 
        while (slots > 0) {
            // try to arrange a pair
            long validChoices = (slots * (slots - 1)) / 2;
            // keep track of the total ways of arranging
            count = (count * validChoices) % mod;
            slots -= 2;
        }
        return (int) count;
    }
}
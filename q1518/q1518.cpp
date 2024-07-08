class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int left = numBottles;
        int ans = numBottles;
        while (left >= numExchange) {
            ans += left / numExchange;
            left = (left / numExchange) + (left % numExchange);
        }
        return ans;
    }
};
class Solution {
public:
    bool checkSquare(int n) {
        if (n < 0) {
            return false;
        }
        int sqRoot = int(sqrt(n));
        return sqRoot * sqRoot == n;
    }
    bool judgeSquareSum(int c) {
         if (c == 0) {
            return true;
        }

        int limit = int(sqrt(c)); // max -> sqrt(2^31-1) = 46340
        for (int i = 1; i <= limit; ++i) {
            if (checkSquare(c - i * i)) {
                std::cout << i << std::endl;
                return true;
            }
        }
        return false;       
    }
};
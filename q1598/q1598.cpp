class Solution {
public:
    int minOperations(vector<string>& logs) {
        int steps = 0;
        for (const auto& log : logs) {
            if (log == "../") {
                if (steps != 0) {
                    steps -= 1;
                }
            } else if (log != "./") {
                steps += 1;
            }
        }
        return steps; 
    }
};
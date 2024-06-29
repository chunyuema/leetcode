        std::stack<std::pair<int, int>> stack;
        int maxArea = 0;
        int n = heights.size();
        
        for (int i = 0; i < n; ++i) {
            if (!stack.empty() && stack.top().second <= heights[i]) {
                stack.push({i, heights[i]});
            } else {
                int pos = 0;
                while (!stack.empty() && stack.top().second > heights[i]) {
                    auto [idx, height] = stack.top();
                    maxArea = std::max(maxArea, height * (i - idx));
                    pos = idx;
                    stack.pop();
                }
                stack.push({pos, heights[i]});
            }
        }
        
        while (!stack.empty()) {
            auto [idx, height] = stack.top();
            maxArea = std::max(maxArea, height * (n - idx));
            stack.pop();
        }
        
        return maxArea;
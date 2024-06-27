class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        auto euclidDistance = [](int x, int y) {
            return sqrt((x * x) + (y * y));
        };

        vector<tuple<double, int, int>> pointDist;
        vector<vector<int>> res;

        for (const auto& point : points) {
            double dist = euclidDistance(point[0], point[1]);
            pointDist.emplace_back(dist, point[0], point[1]);
        }
        // C++ way to make minHeap using greater<> in priority queue
        priority_queue<tuple<double, int, int>, vector<tuple<double, int, int>>, greater<tuple<double, int, int>>> minHeap(pointDist.begin(), pointDist.end());

        for (int i = 0; i < k; ++i) {
            auto [dist, x, y] = minHeap.top();
            minHeap.pop();
            res.push_back({x, y});
        }

        return res;
    }
};
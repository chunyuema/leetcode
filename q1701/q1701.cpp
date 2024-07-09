class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        long long start = customers[0][0];
        long long timepass = 0;

        for (const auto& customer : customers) {
            long long arrival = customer[0];
            long long prep = customer[1];
            start = std::max(start, arrival) + prep;
            timepass += (start - arrival);
            std::cout << start << " " << timepass << std::endl;
        }

        return (double)(timepass) / customers.size();
    }
};
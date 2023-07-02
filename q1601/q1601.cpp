#include <vector>
using namespace std;

class Solution
{
public:
    int maximumRequests(int n, vector<vector<int>> &requests)
    {
        vector<int> buildingBalanced(n, 0);
        return maxReqHelper(buildingBalanced, requests, 0, 0);
    }

private:
    int maxReqHelper(vector<int> &buildingBalanced, vector<vector<int>> &requests, int requestIndex, int maxReqSatisfied)
    {

        // base case: if we finish processing all requests
        // check if the buildings are all balanced, if so, return the maxReqSatisfied, otherwise return 0
        if (requestIndex == requests.size())
        {
            for (int b : buildingBalanced)
            {
                if (b != 0)
                    return 0;
            }
            return maxReqSatisfied;
        }

        int srcBuilding = requests[requestIndex][0];
        int dstBuilding = requests[requestIndex][1];

        // satisfy the request, and recursively compute the max
        buildingBalanced[srcBuilding]--;
        buildingBalanced[dstBuilding]++;
        int ans1 = maxReqHelper(buildingBalanced, requests, requestIndex + 1, maxReqSatisfied + 1);

        // backtrack, do not satisfy the request and recursively compute the max
        buildingBalanced[srcBuilding]++;
        buildingBalanced[dstBuilding]--;
        int ans2 = maxReqHelper(buildingBalanced, requests, requestIndex + 1, maxReqSatisfied);

        return max(ans1, ans2);
    }
};
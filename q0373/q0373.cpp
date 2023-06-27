#include <set>
#include <queue>
#include <vector>
using namespace std;

class Solution
{
public:
    vector<vector<int>> kSmallestPairs(vector<int> &nums1, vector<int> &nums2, int k)
    {
        vector<vector<int>> res;
        set<pair<int, int>> onHeap;
        priority_queue<pair<int, pair<int, int>>,
                       vector<pair<int, pair<int, int>>>,
                       greater<pair<int, pair<int, int>>>>
            minHeap;

        minHeap.push({nums1[0] + nums2[0], {0, 0}});
        onHeap.insert({0, 0});

        while (k > 0 && !minHeap.empty())
        {
            // Obtain the min sum and add to the answer
            pair<int, pair<int, int>> minSumPair = minHeap.top();
            minHeap.pop();
            int i = minSumPair.second.first;
            int j = minSumPair.second.second;
            res.push_back({nums1[i], nums2[j]});
            k--;

            // Explore the next pair (i+1, j)
            pair<int, int> nextPair1(i + 1, j);
            if (i + 1 < nums1.size() && onHeap.find(nextPair1) == onHeap.end())
            {
                minHeap.push({nums1[i + 1] + nums2[j], nextPair1});
                onHeap.insert(nextPair1);
            }

            // Explore the next pair (i, j+1)
            pair<int, int> nextPair2(i, j + 1);
            if (j + 1 < nums2.size() && onHeap.find(nextPair2) == onHeap.end())
            {
                minHeap.push({nums1[i] + nums2[j + 1], nextPair2});
                onHeap.insert(nextPair2);
            }
        }

        return res;
    }
};
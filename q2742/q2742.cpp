class Solution
{
public:
    int paintWalls(vector<int> &cost, vector<int> &time)
    {
        vector<vector<int>> memo(cost.size(), vector<int>(cost.size() + 1, -1));
        return dpHelper(cost, time, 0, cost.size(), memo);
    }

private:
    int dpHelper(const vector<int> &cost,
                 const vector<int> &time,
                 int currIdx,
                 int remainingWalls,
                 vector<vector<int>> &memo)
    {

        if (remainingWalls <= 0)
            return 0;

        if (currIdx >= cost.size())
            return 1e9;

        if (memo[currIdx][remainingWalls] != -1)
            return memo[currIdx][remainingWalls];

        // hire the painter to paint the current wall. while the painter takes time[currIdx]
        // amount of time to paint, the free painter can paint time[currIdx] number of walls
        // hence, the remaining walls can be updated to be remainingWalls - 1 - time[currIdx]
        int newRemainingWalls = remainingWalls - 1 - time[currIdx];
        int hire = cost[currIdx] + dpHelper(cost, time, currIdx + 1, newRemainingWalls, memo);

        // do not hire a painter, hence the number of remining walls stays the same
        // note that if the paid painter is not working, the free painter cannot work
        int noHire = dpHelper(cost, time, currIdx + 1, remainingWalls, memo);

        memo[currIdx][remainingWalls] = min(hire, noHire);
        return memo[currIdx][remainingWalls];
    }
};
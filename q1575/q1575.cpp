#include <vector>
using namespace std;

class Solution
{
public:
    int countRoutes(vector<int> &locations, int start, int finish, int fuel)
    {
        vector<vector<int>> memo(locations.size(), vector<int>(fuel + 1, -1));
        return dpHelper(locations, start, finish, fuel, memo);
    }

private:
    int dpHelper(vector<int> &locations, int currentLoc, int finish, int fuelLeft, vector<vector<int>> &memo)
    {
        // base case 1: return 0 if no fuel is left
        if (fuelLeft < 0)
            return 0;

        // dynamic programming: if we have previously computed memo[currentLoc][fuelLeft], return the answer
        if (memo[currentLoc][fuelLeft] != -1)
            return memo[currentLoc][fuelLeft];

        // if currentLoc == finish, we already have 1 way to get from currentLoc to finish: stay put
        int totalRoutes = currentLoc == finish ? 1 : 0;

        for (int nextLoc = 0; nextLoc < locations.size(); nextLoc++)
        {
            // we only make the move if nextLoc is not the same as the currentLoc
            if (nextLoc != currentLoc)
            {
                // recursively compute the number of routes from next position on wards
                int fuelUsed = abs(locations[nextLoc] - locations[currentLoc]);
                totalRoutes = (totalRoutes + dpHelper(locations, nextLoc, finish, fuelLeft - fuelUsed, memo)) % 1000000007;
            }
        }

        // store the answer in the memo before returning the answer
        memo[currentLoc][fuelLeft] = totalRoutes;
        return totalRoutes;
    }
};
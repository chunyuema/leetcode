#include <vector>
using namespace std;

class Solution
{
public:
    bool asteroidsDestroyed(int mass, vector<int> &asteroids)
    {
        sort(asteroids.begin(), asteroids.end());
        long currentMass = mass;
        for (int i = 0; i < asteroids.size(); i++)
        {
            if (currentMass < asteroids[i])
                return false;
            currentMass += asteroids[i];
        }
        return true;
    }
};
class Solution
{
public:
    int minTimeToVisitAllPoints(vector<vector<int>> &points)
    {
        int minTime = 0;
        for (int i = 1; i < points.size(); i++)
        {
            minTime += getMinTimeBetweenTwoPoints(points[i], points[i - 1]);
        }
        return minTime;
    }

private:
    int getMinTimeBetweenTwoPoints(const vector<int> &p1, const vector<int> &p2)
    {
        int xDist = abs(p1[0] - p2[0]);
        int yDist = abs(p1[1] - p2[1]);
        return max(xDist, yDist);
    }
};
class Solution
{
public:
    vector<vector<int>> imageSmoother(vector<vector<int>> &img)
    {
        int m = img.size();
        int n = img[0].size();
        vector<vector<int>> smoothedImg(m, vector<int>(n));
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int sum = img[i][j];
                int count = 1;
                for (vector<int> dir : dirs)
                {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n)
                    {
                        sum += img[newI][newJ];
                        count++;
                    }
                }
                smoothedImg[i][j] = sum / count;
            }
        }
        return smoothedImg;
    }

private:
    vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
};
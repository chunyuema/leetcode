class Solution
{
public:
    int numSpecial(vector<vector<int>> &mat)
    {
        int r = mat.size();
        int c = mat[0].size();
        vector<int> rowRecord(r, 0);
        vector<int> colRecord(c, 0);
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (mat[i][j] == 1)
                {
                    rowRecord[i]++;
                    colRecord[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (mat[i][j] == 1 && rowRecord[i] == 1 && colRecord[j] == 1)
                {
                    res++;
                }
            }
        }
        return res;
    }
};
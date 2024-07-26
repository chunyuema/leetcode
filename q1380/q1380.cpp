class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        vector<int> row(matrix.size(), -1);
        vector<int> col(matrix[0].size(), -1);
        vector<int> ans;
        
        for (int i = 0; i < matrix.size(); ++i) {
            int mini = INT_MAX;
            for (int j = 0; j < matrix[0].size(); ++j) {
                mini = min(mini, matrix[i][j]);
            }
            row[i] = mini;
        }
        
        for (int i = 0; i < matrix[0].size(); ++i) {
            int maxi = 0;
            for (int j = 0; j < matrix.size(); ++j) {
                maxi = max(maxi, matrix[j][i]);
            }
            col[i] = maxi;
        }
        
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = 0; j < matrix[0].size(); ++j) {
                if (matrix[i][j] == row[i] && matrix[i][j] == col[j]) {
                    ans.push_back(matrix[i][j]);
                }
            }
        }
        
        return ans; 
    }
};
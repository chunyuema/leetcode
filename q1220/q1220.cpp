class Solution {
public:
    int countVowelPermutation(int n) {
        long long a, e, i, o, u, sum, mod;
        vector<vector<long long>>dp;
        dp.push_back({});
        dp.push_back({1, 1, 1, 1, 1});
        a = 0, e = 1, i = 2, o = 3, u = 4;
        mod = 1e9 + 7;
        // bottom-up approach considering the letter constraints that could be followed by  
        for(int j = 2; j < n + 1; j ++){
            dp.push_back({0, 0, 0, 0, 0});

            dp[j][a] = (dp[j - 1][e] + dp[j - 1][i] + dp[j - 1][u]) % mod;
            dp[j][e] = (dp[j - 1][a] + dp[j - 1][i]) % mod;
            dp[j][i] = (dp[j - 1][e] + dp[j - 1][o]) % mod;
            dp[j][o] = dp[j - 1][i];
            dp[j][u] = (dp[j - 1][i] + dp[j - 1][o]) % mod;
        }
        sum = 0;
        for(auto s: dp[n]){
            sum += (s % mod);
        }
        return sum % mod;
    }
};
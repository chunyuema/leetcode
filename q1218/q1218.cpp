class Solution
{
public:
    int longestSubsequence(vector<int> &arr, int difference)
    {
        int longestLen = 1;
        // memo[i] = longest subsequence until int i with the given difference
        unordered_map<int, int> memo;
        for (int currInt : arr)
        {
            int targetInt = currInt - difference;
            // If the targetInt has appeared before, get the longest subsequence len
            // If the targetInt has not appeared before, get 0 as the previous longest is 0
            // The new len is previous len + 1, and then update the dp map, as well as the
            // result
            int currLen = memo[targetInt] + 1;
            memo[currInt] = currLen;
            longestLen = max(longestLen, currLen);
        }
        return longestLen;
    }
};
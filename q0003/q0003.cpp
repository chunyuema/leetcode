#include <string>
#include <unordered_map>
using namespace std;

class Solution
{
public:
    int lengthOfLongestSubstring(string s)
    {
        int longestLength = 0;
        unordered_map<char, int> charIndex;
        int l = 0;
        for (int r = 0; r < s.size(); r++)
        {
            char currChar = s[r];
            if (charIndex.find(currChar) != charIndex.end())
            {
                l = max(l, charIndex[currChar] + 1);
            }
            longestLength = max(longestLength, r - l + 1);
            charIndex[currChar] = r;
        }
        return longestLength;
    }
};
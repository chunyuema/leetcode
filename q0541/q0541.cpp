#include <string>
using namespace std;

class Solution
{
public:
    string reverseStr(string s, int k)
    {
        int n = s.size();
        for (int l = 0; l < n; l += 2 * k)
        {
            int r = min(l + k, n);
            // Or replace the following lines with:
            // reverse(s.begin()+l, s.begin()+r);
            for (int i = l, j = r - 1; i < j; i++, j--)
            {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
            }
        }
        return s;
    }
};
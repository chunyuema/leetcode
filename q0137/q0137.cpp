#include <vector>
using namespace std;

class Solution
{
public:
    int singleNumber(vector<int> &nums)
    {
        int ones = 0;
        int twos = 0;
        for (int num : nums)
        {
            // If the bit is in twos, that means it is flipped 2 times already, hence do not account for it
            // but flip the bits to account for the num that appears for the first time, as they might the one that appears only once
            ones = (~twos) & (ones ^ num);

            // If the bit is flipped in ones, that means we have only seen 1 of that number so far, hence do not account for it
            // But flip the bits to account for the num that appears for the second time, as they are definitely not the number we want
            twos = (~ones) & (twos ^ num);
        }
        return ones;
    }
};
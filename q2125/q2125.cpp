class Solution
{
public:
    int numberOfBeams(vector<string> &bank)
    {
        int prevCount = 0;
        int totalBeam = 0;
        for (const string &s : bank)
        {
            int currCount = 0;
            for (const char c : s)
            {
                if (c == '1')
                    currCount++;
            }

            // Only update the totalBeam if the row has some devices
            if (currCount != 0)
            {
                totalBeam += prevCount * currCount;
                // We only need to track the last count of the devices in the row
                prevCount = currCount;
            }
        }
        return totalBeam;
    }
};
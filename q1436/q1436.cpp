class Solution
{
public:
    string destCity(vector<vector<string>> &paths)
    {
        unordered_set<string> outgoingCities;
        for (const vector<string> &path : paths)
        {
            outgoingCities.insert(path[0]);
        }

        for (const vector<string> &path : paths)
        {
            string dest = path[1];
            if (outgoingCities.find(dest) == outgoingCities.end())
                return dest;
        }

        return "";
    }
};
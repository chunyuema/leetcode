class Solution
{
public:
    int findSpecialInteger(vector<int> &arr)
    {
        int i = 0;
        int n = arr.size() / 4;
        while (i < arr.size() - n)
        {
            if (arr[i] == arr[i + n])
                return arr[i];
            i++;
        }
        return -1;
    }
};
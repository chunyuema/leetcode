class Solution
{
public:
    int maxProductDifference(vector<int> &nums)
    {
        int largest = 0;
        int secondLargest = 0;

        int smallest = INT_MAX;
        int secondSmallest = INT_MAX;

        for (const int num : nums)
        {
            if (num > largest)
            {
                secondLargest = largest;
                largest = num;
            }
            else
            {
                secondLargest = max(secondLargest, num);
            }

            if (num < smallest)
            {
                secondSmallest = smallest;
                smallest = num;
            }
            else
            {
                secondSmallest = min(secondSmallest, num);
            }
        }

        return largest * secondLargest - smallest * secondSmallest;
    }
};
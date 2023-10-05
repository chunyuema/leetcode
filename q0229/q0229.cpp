class Solution
{
public:
    vector<int> majorityElement(vector<int> &nums)
    {
        int num1 = INT_MIN;
        int num2 = INT_MIN;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums)
        {
            if (num == num1)
                count1++;
            else if (num == num2)
                count2++;

            // if count1 is zero, assign the current number to num1
            else if (count1 == 0)
            {
                num1 = num;
                count1++;
            }

            // if count2 is zero, assign the current number to num2
            else if (count2 == 0)
            {
                num2 = num;
                count2++;
            }

            // if num does not match any of num1 and num2, reduce their
            // count to track this
            else
            {
                count1--;
                count2--;
            }
        }

        vector<int> res;
        count1 = 0;
        count2 = 0;
        for (int num : nums)
        {
            if (num == num1)
                count1++;
            else if (num == num2)
                count2++;
        }
        if (count1 > nums.size() / 3)
            res.push_back(num1);
        if (count2 > nums.size() / 3)
            res.push_back(num2);
        return res;
    }
};
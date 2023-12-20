class Solution
{
public:
    int buyChoco(vector<int> &prices, int money)
    {
        int lowest = INT_MAX;
        int secondLowest = INT_MAX;
        for (const int price : prices)
        {
            if (price < lowest)
            {
                secondLowest = lowest;
                lowest = price;
            }
            else
            {
                secondLowest = min(secondLowest, price);
            }
        }
        return money >= (lowest + secondLowest) ? money - (lowest + secondLowest) : money;
    }
};
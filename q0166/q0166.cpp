#include <string>
#include <map>
using namespace std;

class Solution
{
public:
    string fractionToDecimal(int numerator, int denominator)
    {
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";

        string res;

        // Determine the sign of the result
        if ((numerator < 0) ^ (denominator < 0))
            res += "-";

        long num = abs((long)numerator);
        long denom = abs((long)denominator);
        res += to_string(num / denom);

        long remainder = num % denom;
        if (remainder == 0)
            return res;
        res += ".";

        map<long, int> observedRemainder;
        while (remainder != 0 && observedRemainder.find(remainder) == observedRemainder.end())
        {
            observedRemainder[remainder] = res.size();
            remainder *= 10;
            res += to_string(remainder / denom);
            remainder %= denom;
        }

        if (remainder != 0)
        {
            res.insert(observedRemainder[remainder], "(");
            res += ")";
        }
        return res;
    }
};
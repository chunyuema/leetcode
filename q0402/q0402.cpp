string removeKdigits(string num, int k)
{
    vector<char> stack;
    if (k == num.size())
        return "0";
    int i = 0;
    while (i < num.size())
    {
        int n = stack.size();
        while (k && n && stack[n - 1] > num.at(i))
        {
            k--;
            stack.pop_back();
            n = stack.size();
        }
        stack.push_back(num.at(i));
        i++;
    }
    while (k > 0)
    {
        stack.pop_back();
        k--;
    }

    int n = stack.size();
    string ans = "";
    while (!stack.empty())
    {
        ans = stack[n - 1] + ans;
        n--;
        stack.pop_back();
    }
    while (ans.size() > 1 && ans[0] == '0')
    {
        ans = ans.substr(1);
    }
    return ans;
}
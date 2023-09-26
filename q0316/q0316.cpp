class Solution
{
public:
    string removeDuplicateLetters(string s)
    {
        map<char, int> indexMap;
        for (int i = 0; i < s.size(); i++)
            indexMap[s[i]] = i;

        stack<char> charStack;
        set<char> charSet;
        for (int i = 0; i < s.size(); i++)
        {
            char currChar = s[i];
            if (charSet.find(currChar) == charSet.end())
            {
                while (charStack.size() != 0 &&
                       currChar < charStack.top() &&
                       indexMap[charStack.top()] > i)
                {
                    charSet.erase(charStack.top());
                    charStack.pop();
                }
                charStack.push(currChar);
                charSet.insert(currChar);
            }
        }

        string res;
        while (!charStack.empty())
        {
            res = charStack.top() + res;
            charStack.pop();
        }
        return res;
    }
};
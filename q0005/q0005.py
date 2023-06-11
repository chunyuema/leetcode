class Solution(object):
    def longestPalindrome(self, s):
        if not s:
            return ''

        l = 0
        r = 0

        for i in range(len(s)):
            len1 = self.expandFromCenter(
                s, i, i
            )  ##deals with the case of "racecar", centered around one unique char
            len2 = self.expandFromCenter(s, i, i + 1)  ##deals with the case of "abba"
            lenF = max(len1, len2)
            ## this means we have found new max len palindrome
            if lenF > r - l:
                l = i - ((lenF - 1) // 2)
                r = i + (lenF // 2)
        return s[l : r + 1]

    def expandFromCenter(self, s, l, r):
        if not s or l > r:
            return 0
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        return r - l - 1

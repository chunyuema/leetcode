class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t: return ""
        targetCharCount = defaultdict(int)
        for char in t: targetCharCount[char] += 1

        # Track the minimum length of the string, and the corresponding starting and ending index
        minLen = len(s) + 1
        start, end = 0, 0

        # Track the left and right bound of the window
        left, right = 0, 0
        # Track the character counts in the window
        windowCharCount = defaultdict(int)
        # Track the count of the characters in windowCharCount which satisfy the condition
        numberOfCharMeetingCondition = 0

        while right < len(s):
            # expand the window and update the window condition until requirement is met
            currChar = s[right]
            windowCharCount[currChar] += 1
            if (currChar in targetCharCount) and (windowCharCount[currChar] == targetCharCount[currChar]):
                 numberOfCharMeetingCondition += 1

            # shrink the window and update the window condition until the requirement is not met
            while left <= right and numberOfCharMeetingCondition == len(targetCharCount):
                prevChar = s[left]

                # while shrinking the window, update the minLen as long as the condition still hold
                if right - left + 1 < minLen:
                    minLen = right - left + 1
                    start = left
                    end = right
                
                # update the window condition after updating the minLen and start / end indices
                windowCharCount[prevChar] -= 1
                if (prevChar in targetCharCount) and (windowCharCount[prevChar] < targetCharCount[prevChar]):
                    numberOfCharMeetingCondition -= 1
                
                left += 1
                
            right += 1
        
        return "" if minLen == len(s) + 1 else s[start : end + 1]
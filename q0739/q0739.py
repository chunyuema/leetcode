class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0] * len(temperatures)
        
        # Use monotonic decreasing stack to keep track of the temperatures
        monoStack = []

        for i in range(len(temperatures)-1, -1, -1):
            currTemperature = temperatures[i]
            # maintain the stack to be monotonic decreasing
            while len(monoStack) > 0 and currTemperature >= temperatures[monoStack[-1]]: 
                monoStack.pop()
            # update the res if there is anything left on the stack
            if len(monoStack) != 0: 
                res[i] = monoStack[-1] - i
            # push the currTemp index onto the stack for future tracking
            monoStack.append(i)
        
        return res
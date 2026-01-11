class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        m, n = len(matrix), len(matrix[0])
        histogram = [0 for _ in range(n)]
        res = 0

        # use each row as the base of a histogram    
        # update the histogram based on the current row
        for i in range(m):
            for j in range(n):
                histogram[j] = 0 if matrix[i][j] != '1' else histogram[j] + 1
            
            # process the current histogram to identify the largest rectangle
            res = max(res, self.get_largest_area(histogram))

        return res
    
    # Given a histogram, find the largest rectangle present in the histogram
    def get_largest_area(self, heights: List[int]) -> int:
        stack = []
        max_area = 0

        # loop till len(heights) + 1 to ensure that the last element is processed
        for i in range(len(heights) + 1):
            # handle edge case of i goes out of bound, curr = 0
            curr = 0 if i == len(heights) else heights[i]
            # maintain the monotonically increasing stack
            while (stack and heights[stack[-1]] > curr):
                # when popping the previously bigger heights
                # compute the area it was part of and update max_area
                prev = heights[stack.pop()]
                width = i if not stack else (i - stack[-1] - 1)
                max_area = max(max_area, prev * width)
            stack.append(i)

        return max_area

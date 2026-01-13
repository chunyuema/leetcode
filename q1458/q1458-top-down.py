class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        self.memo = [[None] * len(nums2) for _ in range(len(nums1))]
        return self.dp_helper(nums1, nums2, 0, 0)

    
    # max dot product if you start from index i for nums1, j for nums2
    def dp_helper(self, nums1, nums2, i, j):
        if i >= len(nums1) or j >= len(nums2):
            return float('-inf')

        if self.memo[i][j] != None: 
            return self.memo[i][j]

        take = nums1[i] * nums2[j]
        opt1 = max(take, take + self.dp_helper(nums1, nums2, i+1, j+1))
        opt2 = self.dp_helper(nums1, nums2, i+1, j)
        opt3 = self.dp_helper(nums1, nums2, i, j+1)
        res  = max(opt1, opt2, opt3)
        self.memo[i][j] = res

        return res 

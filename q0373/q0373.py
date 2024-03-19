class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        # pq stores the (sum, i, j) which tracks the smallest sum and the pair of indices
        pq = []
        heappush(pq, (nums1[0] + nums2[0], 0, 0))

        # checked stores whether a pair of indices have already been visited
        checked = set([(0, 0)])

        res = []
        while (k > 0 and pq):
            # Poll the pair of index which gives the lowest sum and add that to the result
            currPair = heappop(pq)
            i, j = currPair[1], currPair[2]
            res.append([nums1[i], nums2[j]])
            k -= 1 

            # Explore the next possible lowest sum by incrementing index i only
            if i + 1 < len(nums1) and (i+1, j) not in checked:
                heappush(pq, (nums1[i+1] + nums2[j], i+1, j))
                checked.add((i+1, j))

            # Explore the next possible lowest sum by incrementing index j only
            if j + 1 < len(nums2) and (i, j+1) not in checked: 
                heappush(pq, (nums1[i] + nums2[j+1], i, j+1))
                checked.add((i, j+1))

        return res
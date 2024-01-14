class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        # all the heights diff climbed with ladders (sorted from small -> big)
        heightsWithLadders = []


        for i in range(1, len(heights)):
            heightDiff = heights[i] - heights[i-1]
            if (heightDiff > 0):
                heapq.heappush(heightsWithLadders, heightDiff)
            
            # no more ladders to use
            if (len(heightsWithLadders) > ladders):
                # climb previous recorded smallest height with bricks instead and use ladder for the current climb
                # since the bricks were used on the smallest height from before, we can greedily go as far as possible
                bricks -= heapq.heappop(heightsWithLadders)
            if bricks < 0: 
                return i - 1
        return len(heights) - 1
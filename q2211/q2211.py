class Solution:
    def countCollisions(self, directions: str) -> int:
        collisions = 0
        # -1 == All clear on the previous cars (no collisions)
        # 0  == There is at least 1 collision / stopped car on the left
        # N  == there are N cars moving to the right
        prev = -1
        for curr in directions:
            if curr =='L':
                # All previous R moving cars / S cars will collide
                if prev >= 0:
                    # All R moving car each contribute 1 to collision
                    # Curr L moving car contributes 1 to collision
                    collisions += prev + 1
                    prev = 0

            elif curr == 'S':
                # Only previous R moving cars will collide 
                if prev > 0:
                    # All R moving car each contribute 1 to collision
                    # Curr S car does not contribute to collision
                    collisions += prev
                # No more chances of collision from the left
                prev = 0
            
            else:
                if prev >= 0: prev += 1
                else: prev = 1
        return collisions

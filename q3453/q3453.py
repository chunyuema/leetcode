class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        total_area = 0
        events = []

        for _, y, l in squares:
            total_area += l * l
            events.append((y, l))       # entering
            events.append((y + l, -l))  # leaving

        # Sort by y-coordinate
        events.sort(key=lambda e: e[0])

        # Track the active_width from prev_y to the curr_y
        active_width = 0
        acc_area = 0
        prev_y = events[0][0]

        for curr_y, delta in events:
            # scanning line from prev_y to curr_y
            height = curr_y - prev_y
            # the added area to the acc_area is area_added
            area_added = height * active_width

            # If midpoint is in this segment
            if (acc_area + area_added) * 2 >= total_area:
                # Only need remaining amount to get midpoint (greedy)
                remaining = (total_area / 2) - acc_area
                return prev_y + remaining / active_width
            
            # If midpoint is not in the previous segment
            # Count fully the area increemented from prev_y to curr_y
            acc_area += area_added
            active_width += delta
            prev_y = y

        return 0.0


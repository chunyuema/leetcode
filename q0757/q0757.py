class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        # Sort by end, then start — this makes greedy possible
        intervals.sort(key=lambda i: (i[1], i[0]))
        
        # prev1, prev2 always represent the **two largest elements**
        # in our chosen set so far (prev1 > prev2).
        # Starting with the first interval's largest two numbers.
        prev1 = intervals[0][1]
        prev2 = prev1 - 1
        min_set = 2
        
        for s, e in intervals:
            # CASE 1 — [s ... prev2 ... prev1 ... e]
            if s <= prev2:
                # This interval already has ≥2 chosen numbers → do nothing.
                continue

            # CASE 2 — interval contains only prev1:
            if s <= prev1:
                # [s ... prev1 ... e] but s > prev2 - We need to add 1 number to ensure 2 coverage. 
                min_set += 1

                # Choose the largest number in this interval, which is e.
                # Subcase A: e > prev1 → truly adding a new, larger number.
                # The new two largest become: (e, prev1)
                if e > prev1:
                    prev2 = prev1
                    prev1 = e
                else:
                    # Subcase B: e == prev1 → the “added” number equals prev1.
                    # Then the second-largest must become prev1 - 1
                    # to keep (prev1, prev2) as the two largest chosen numbers.
                    prev2 = prev1 - 1

            # CASE 3 — interval contains neither prev1 nor prev2: [s ... e] with s > prev1
            else:
                # Must add 2 numbers: e and e-1 (largest possible choices).
                min_set += 2
                prev1 = e
                prev2 = e - 1

        return min_set

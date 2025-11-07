class Solution:
    def maxPower(self, stations: List[int], r: int, k: int) -> int:
        n = len(stations)

        # --- 1️⃣ Build difference array for initial station powers ---
        # power_diff[i] represents the net change in power at city i
        power_diff = [0] * (n + 1)
        for i, station_power in enumerate(stations):
            start = max(0, i - r)          # start of range affected by this station
            end = min(n, i + r + 1)        # end of range +1 for difference array
            power_diff[start] += station_power
            power_diff[end] -= station_power

        # --- 2️⃣ Binary search to maximize minimum city power ---
        lo, hi = min(stations), sum(stations) + k
        max_min_power = 0
        while lo <= hi:
            mid_power = (lo + hi) // 2
            # Check if it is possible to make every city >= mid_power
            if self.canAchieve(mid_power, power_diff[:], k, r):
                max_min_power = mid_power
                lo = mid_power + 1
            else:
                hi = mid_power - 1
        return max_min_power

    # --- 3️⃣ Greedy check using difference array ---
    def canAchieve(self, target_power: int, diff: List[int], remaining_stations: int, radius: int) -> bool:
        running_power = 0            # running sum of current power at city i
        n = len(diff) - 1

        for city in range(n):
            running_power += diff[city]   # apply all previous additions

            if running_power < target_power:
                needed = target_power - running_power

                # Not enough stations left to reach target
                if remaining_stations < needed:
                    return False

                remaining_stations -= needed
                running_power += needed   # apply new stations immediately

                # Use difference array to stop the effect after coverage range
                stop_index = min(n, city + 2 * radius + 1)
                diff[stop_index] -= needed

        return True

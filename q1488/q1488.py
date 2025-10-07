class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        res = [1] * len(rains)
        sorted_dry_days = SortedList()
        lake_to_day = dict()
        for day, lake in enumerate(rains): 
            if lake == 0:
                sorted_dry_days.add(day)
            else: 
                res[day] = -1
                if lake in lake_to_day:
                    rainy_day = lake_to_day[lake]
                    # search for the first day before the rainy days
                    dry_day_idx = sorted_dry_days.bisect(rainy_day)
                    if (dry_day_idx == len(sorted_dry_days)): return []
                    dry_day = sorted_dry_days[dry_day_idx]
                    res[dry_day] = lake
                    sorted_dry_days.discard(dry_day)
                lake_to_day[lake] = day
        return res
               

func repairCars(ranks []int, cars int) int64 {
	lo, hi := int64(1), int64(ranks[0]*cars*cars) // Initial low and high bounds for binary search

	// Binary search for the minimum time required to repair the cars
	for lo < hi {
		mid := (lo + hi) / 2
		totalCarsRepairedInMid := totalCarsRepaired(mid, ranks)

		if totalCarsRepairedInMid < int64(cars) {
			// If mid is not sufficient time to repair cars, increase lo
			// to find more time to repair all cars
			lo = mid + 1
		} else {
			// If mid is sufficient time to repair cars, decrease hi to see
			// if we can repair the cars in less time
			hi = mid
		}
	}
	return lo
}

func totalCarsRepaired(totalTime int64, ranks []int) int64 {
	var totalCars int64

	// Calculate total cars repaired for the given total time
	for _, rank := range ranks {
		totalCars += int64(math.Sqrt(float64(totalTime) / float64(rank)))
	}

	return totalCars
}


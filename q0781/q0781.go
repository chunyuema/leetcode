func numRabbits(answers []int) int {
    groupsBySizes := make(map[int]int)
    for _, ans := range answers {
        // Get group size
        size := ans + 1
        count, exists := groupsBySizes[size]
        if exists {
            groupsBySizes[size] = count + 1
        } else {
            groupsBySizes[size] = 1
        }
    }

    totalRabbits := 0
    for size, count := range groupsBySizes {
        numOfGroups := count / size
        if count % size != 0 {
            numOfGroups++
        }
        totalRabbits += (size * numOfGroups)
    }
    return totalRabbits
}

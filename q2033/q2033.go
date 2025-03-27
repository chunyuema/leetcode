func minOperations(grid [][]int, x int) int {
    var nums []int
    prev := grid[0][0]

    for i := 0; i < len(grid); i++ {
        for j := 0; j < len(grid[0]); j++ {
            curr := grid[i][j]
            if (curr - prev) % x != 0 {
                return -1
            }
            nums = append(nums, curr)
        }
    }
    
    sort.Ints(nums)

    minOps := 0
    median := nums[len(nums) / 2]
    for _, num := range nums {
        minOps += int(math.Abs(float64((num - median)/x)))
    }
    return minOps;
}

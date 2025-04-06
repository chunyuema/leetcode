func largestDivisibleSubset(nums []int) []int {
    sort.Ints(nums)

    dp := make([]int, len(nums))
    for i := range dp {
        dp[i] = 1
    }

    prev := make([]int, len(nums))
    for i := range prev {
        prev[i] = -1
    }

    maxIndex := 0
    for i := range nums {
        for j := range i {
            if nums[i] % nums[j] == 0 {
                newLen := dp[j] + 1
                if newLen > dp[i] {
                    dp[i] = newLen
                    prev[i] = j
                }
            }
        }
        if dp[i] > dp[maxIndex] {
            maxIndex = i
        }
    }

    res := make([]int, len(nums))  // Use a slice for dynamic length
    i := 0
    for k := maxIndex; k >= 0; k = prev[k] {
        res[i] = nums[k]
        i++
    }
    return res[:i]  
}

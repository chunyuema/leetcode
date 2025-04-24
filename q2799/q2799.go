func countCompleteSubarrays(nums []int) int {
    set := make(map[int]bool)
    for _, num := range nums {
        set[num] = true
    }
    unique := len(set)

    r := 0
    curr := make(map[int]int)
    count := 0
    for l := 0; l < len(nums); l++ {
        if l > 0 {
            remove := nums[l - 1]
            curr[remove]--
            if curr[remove] == 0 {
                delete(curr, remove)
            }
        }

        for r < len(nums) && len(curr) < unique {
            add := nums[r]
            curr[add]++
            r++
        }

        if len(curr) == unique {
            count += len(nums) - r + 1
        }
    }
    
    return count
}

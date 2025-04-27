func countInterestingSubarrays(nums []int, modulo int, k int) int64 {
    cntMap := make(map[int]int)
    cntMap[0] = 1

    prefix := 0
    var totalSubarrays int64 = 0
    for _, num := range nums {
        if num % modulo == k { prefix++ }
        target := (prefix - k + modulo) % modulo
        totalSubarrays += int64(cntMap[target])
        cntMap[prefix % modulo]++
    }
    return totalSubarrays
}

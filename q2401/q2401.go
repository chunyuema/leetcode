func longestNiceSubarray(nums []int) int {
    currBitsUsed := 0
    l := 0
    res := 1

    for r := 0; r < len(nums); r++ {
        for currBitsUsed & nums[r] != 0 {
            currBitsUsed ^= nums[l]
            l++
        }
        
        currBitsUsed |= nums[r]

        res = max(res, r - l + 1)
    }

    return res
}

func minSum(nums1 []int, nums2 []int) int64 {
    var sum1, sum2, zero1, zero2 int64 = 0, 0, 0, 0
    for _, num := range nums1 {
        sum1 += int64(num)
        if num == 0 {
            zero1++
        }
    }

    for _, num := range nums2 {
        sum2 += int64(num)
        if num == 0 {
            zero2++
        }
    }

    if zero1 == 0 && zero2 == 0 {
        if sum1 == sum2 {
            return sum1
        } 
        
        return -1
    } 
    
    if (zero1 == 0) {
        if (sum2 + zero2 <= sum1) {
            return sum1
        } 

        return -1
    }

    if (zero2 == 0) {
        if (sum1 + zero1 <= sum2) {
            return sum2
        }
        
        return -1
    }

    
    return max(sum1 + zero1, sum2 + zero2)
}

func max(a, b int64) int64 {
    if a < b {
        return b
    }
    return a
}

def maxProduct(nums):
    res, curr_max, curr_min = nums[0], nums[0], nums[0]
    for num in nums[1:]:
        tempMax = max(num, curr_max * num, curr_min * num)
        tempMin = min(num, curr_max * num, curr_min * num)
        curr_max = tempMax
        curr_min = tempMin
        res = max(res, curr_max)
    return res

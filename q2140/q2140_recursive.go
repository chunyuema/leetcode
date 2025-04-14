func mostPoints(questions [][]int) int64 {
    memo := make([] int64, len(questions))
    for i := range(memo) {
        memo[i] = -1
    }
    return dpHelper(0, memo, questions)
}

// represent the max points if you start from index i
func dpHelper(i int, memo []int64, questions [][]int) int64 {
    if i >= len(questions) {
        return 0
    }

    if memo[i] != -1 {
        return memo[i]
    }

    currQuestion := questions[i]
    skip := dpHelper(i+1, memo, questions)
    noSkip := int64(currQuestion[0]) + dpHelper(i + currQuestion[1] + 1, memo, questions)

    if skip > noSkip {
        memo[i] = skip
    } else {
        memo[i] = noSkip
    }
    
    return memo[i]
}

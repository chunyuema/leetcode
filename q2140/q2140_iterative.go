func mostPoints(questions [][]int) int64 {
	n := len(questions)
	dp := make([]int64, n+1) // dp[i] stores the max points starting from index i

	// Iterate backwards through the questions
	for i := n - 1; i >= 0; i-- {
		points := int64(questions[i][0])
		skip := dp[i+1] // Max points if we skip the current question

		nextIndex := i + questions[i][1] + 1
		take := points
		if nextIndex < n {
			take += dp[nextIndex] // Max points if we take the current question
		}

		if skip > take {
			dp[i] = skip
		} else {
			dp[i] = take
		}
	}

	return dp[0] // The max points starting from the beginning
}

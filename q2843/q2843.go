func countSymmetricIntegers(low int, high int) int {
	var count int
	for num := low; num <= high; num++ { // Corrected loop range
		if checkSymmetry(num) {
			count++
		}
	}
	return count
}

func checkSymmetry(num int) bool {
	s := strconv.Itoa(num) // Convert the number to a string
	n := len(s)
	if n%2 != 0 { // Odd number of digits cannot be symmetric
		return false
	}

	leftSum := 0
	rightSum := 0
	for i := 0; i < n/2; i++ {
		leftDigit, _ := strconv.Atoi(string(s[i]))   // Convert char to int
		rightDigit, _ := strconv.Atoi(string(s[n-1-i])) // Convert char to int
		leftSum += leftDigit
		rightSum += rightDigit
	}
	return leftSum == rightSum
}

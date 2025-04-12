class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int num = low; num <= high; num++) {
            if (isSumSymmetric(num)) { // Renamed for clarity
                count++;
            }
        }
        return count;
    }

    private boolean isSumSymmetric(int num) { // Renamed for clarity
        String s = String.valueOf(num);
        int n = s.length();

        if (n % 2 != 0) {
            return false;
        }

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < n / 2; i++) {
            leftSum += Character.getNumericValue(s.charAt(i));
            rightSum += Character.getNumericValue(s.charAt(n - 1 - i));
        }

        return leftSum == rightSum;
    }
}

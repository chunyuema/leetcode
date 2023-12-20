class Solution {
    public int buyChoco(int[] prices, int money) {
        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < lowest) {
                secondLowest = lowest;
                lowest = price;
            } else {
                secondLowest = Math.min(secondLowest, price);
            }
        }
        return money >= (secondLowest + lowest) ? money - (secondLowest + lowest) : money;
    }
}
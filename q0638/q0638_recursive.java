class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dpHelper(price, special, needs, memo);
    }

    // Let dpHelper(needs)return the lowest price we pay of satifying all the needs
    private int dpHelper(List<Integer> price, List<List<Integer>> special, List<Integer> currNeeds, Map<List<Integer>, Integer> memo) {

        if (memo.containsKey(currNeeds)) return memo.get(currNeeds);

        int minPrice = 0;
        for (int i = 0; i < currNeeds.size(); i++) minPrice += currNeeds.get(i) * price.get(i);

        for (List<Integer> s : special) {

            List<Integer> newNeeds = new ArrayList<>();
            boolean canProceed = true;
            for (int i = 0; i < currNeeds.size(); i++) {
                int newNeed = currNeeds.get(i) - s.get(i);
                if (newNeed < 0) {
                    canProceed = false; 
                    break;
                } else {
                    newNeeds.add(newNeed);
                }
            }
            if (!canProceed) continue;
            minPrice = Math.min(minPrice, s.get(s.size()-1) + dpHelper(price, special, newNeeds, memo));
        }

        memo.put(currNeeds, minPrice);
        return minPrice; 
    }
}
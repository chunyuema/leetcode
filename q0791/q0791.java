class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (charCount.containsKey(c)) {
                int count = charCount.get(c);
                sb.append(String.valueOf(c).repeat(count));
                charCount.put(c, 0);
            }
        }

        for (char c : charCount.keySet()) {
            int count = charCount.get(c);
            sb.append(String.valueOf(c).repeat(count));
        }
        return sb.toString();
    }
}
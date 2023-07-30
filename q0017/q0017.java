class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[] { 'a', 'b', 'c' });
        map.put('3', new Character[] { 'd', 'e', 'f' });
        map.put('4', new Character[] { 'g', 'h', 'i' });
        map.put('5', new Character[] { 'j', 'k', 'l' });
        map.put('6', new Character[] { 'm', 'n', 'o' });
        map.put('7', new Character[] { 'p', 'q', 'r', 's' });
        map.put('8', new Character[] { 't', 'u', 'v' });
        map.put('9', new Character[] { 'w', 'x', 'y', 'z' });

        List<String> res = new ArrayList();
        if (digits.length() == 0)
            return res;
        backtrackHelper(map, res, new StringBuilder(), digits, 0);
        return res;
    }

    private void backtrackHelper(Map<Character, Character[]> map, List<String> res, StringBuilder temp, String digits,
            int idx) {
        if (temp.length() == digits.length()) {
            res.add(temp.toString());
            return;
        }

        for (char c : map.get(digits.charAt(idx))) {
            temp.append(c);
            backtrackHelper(map, res, temp, digits, idx + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
class Solution {
    boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public String sortVowels(String s) {
        ArrayList<Character> vowelList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c))
                vowelList.add(c);
        }
        Collections.sort(vowelList);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (!isVowel(c))
                sb.append(c);
            else {
                sb.append(vowelList.get(i));
                i++;
            }
        }
        return sb.toString();
    }
}
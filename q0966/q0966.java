class Solution {
    Set<String> wordSet = new HashSet<>();
    Map<String, String> wordCap = new HashMap<>();
    Map<String, String> wordVow = new HashMap<>();

    public String[] spellchecker(String[] wordlist, String[] queries) {
        for (String word : wordlist) {
            wordSet.add(word);
            
            String wordLower = word.toLowerCase();
            wordCap.putIfAbsent(wordLower, word);

            String wordDevowel = devowel(word);
            wordVow.putIfAbsent(wordDevowel, word);
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            final String solvedQuery = solve(queries[i]);
            res[i] = solvedQuery;
        }
        return res;
    }

    private String solve(String query) {
        if (wordSet.contains(query)) return query;
        
        String queryLower = query.toLowerCase(); 
        if (wordCap.containsKey(queryLower)) return wordCap.get(queryLower);

        String queryDevowel = devowel(query);
        if (wordVow.containsKey(queryDevowel)) return wordVow.get(queryDevowel);

        return "";
    }

    private String devowel(String s) {
        s = s.toLowerCase();  // Ensure consistent casing
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) == -1) {
                sb.append(c);
            } else {
                sb.append('*');
            }
        }
        return sb.toString();
    }
}

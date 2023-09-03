class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;

    public TrieNode() {
    }
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character currChar = word.charAt(i);
            if (!currNode.children.containsKey(currChar)) {
                currNode.children.put(currChar, new TrieNode());
            }
            currNode = currNode.children.get(currChar);
        }
        currNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    // A recursive implementation of the searching in trie.
    private boolean searchHelper(String word, int i, TrieNode node) {
        if (i >= word.length())
            return node.isEndOfWord;
        if (node == null)
            return false;
        Character currChar = word.charAt(i);
        if (currChar != '.') {
            // follow the regular searching in trie
            if (!node.children.containsKey(currChar))
                return false;
            return searchHelper(word, i + 1, node.children.get(currChar));
        } else {
            boolean found = false;
            // recursively search for all the possible TrieNodes if you see a '.'
            // if any of them return true, then we managed to find a word
            for (TrieNode n : node.children.values()) {
                found = found || searchHelper(word, i + 1, n);
            }
            return found;
        }
    }
}
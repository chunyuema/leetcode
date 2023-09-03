class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
    
    public TrieNode() {}
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
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
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character currChar = word.charAt(i);
            if (!currNode.children.containsKey(currChar)) return false; 
            currNode = currNode.children.get(currChar);
        }
        return currNode.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character currChar = prefix.charAt(i);
            if (!currNode.children.containsKey(currChar)) return false; 
            currNode = currNode.children.get(currChar);
        }
        return true;
    }
}
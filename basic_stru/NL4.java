class Trie {

    private Node root = new Node();
    /** Initialize your data structure here. */
    public Trie() {}
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.child[index] == null) {
                p.child[index] = new Node();
            }
            p = p.child[index];
        }
        p.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.child[index] == null) return false;

            p = p.child[index];
        }

        return p.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node p = root;

        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (p.child[index] == null) return false;

            p = p.child[index];
        }

        return p != null;
    }

    private static class Node {
        private boolean isEnd;
        private Node[] child = new Node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

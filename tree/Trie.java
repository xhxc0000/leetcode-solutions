public class TrieNode {


    private TrieNode[] son = new TrieNode[26];
    private int count = 0;
    private boolean isLeaf;


    public void insert(String s) {

        TrieNode p = this;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (p.son[c] == null) p.son[c] = new TrieNode();
            p = p.son[c];
        }
        p.isLeaf = true;
        p.count++;
    }

    public int query(String s) {
        TrieNode p = this;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (p.son[c] == null) return 0;

            p = p.son[c];
        }

        return p.isLeaf ? p.count : 0;
    }
}

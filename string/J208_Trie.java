public class J208_Trie {
  private Node root;


  public J208_Trie() {
    this.root = new Node();
  }

  public void insert(String word) {
    if (word == null || word.equals("")) return;
    Node p = root;
    for (int i = 0; i < word.length(); i++) {
      int dif = word.charAt(i) - 'a';
      if (p.son[dif] == null) {
        p.son[dif] = new Node();
      }
      p = p.son[dif];
    }
    p.isEnd = true;
  }


  public boolean search(String word) {
    Node p = root;
    for (int i = 0; i < word.length(); i++) {
      int dif = word.charAt(i) - 'a';
      if (p.son[dif] != null) {
        p = p.son[dif];
      } else {
        return false;
      }
    }
    return p.isEnd;
  }

  public boolean startsWith(String prefix) {
    Node p = root;
    for (int i = 0; i < prefix.length(); i++) {
      int dif = prefix.charAt(i) - 'a';
      if (p.son[dif] == null) {
        return false;
      } else {
        p = p.son[dif];
      }
    }
    return p != null;
  }






  // new Node();  son[0] = null,,,
  static class Node {
    boolean isEnd;
    Node[] son = new Node[26];
  }


  public static void main(String[] args) {
    J208_Trie trie = new J208_Trie();
    trie.insert("apple");
    trie.insert("apple");
    System.out.println(trie.search("apple"));
    System.out.println(trie.startsWith("a"));
  }
}

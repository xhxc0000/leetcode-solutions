public class J706_DesignHashMap {
  public static void main(String[] args) {
    J706_DesignHashMap map = new J706_DesignHashMap();
    map.put(1, 2);
    map.put(1000, 16);
    map.remove(1000);
    System.out.println(map.get(1000));
  }

  class Node {
    int key, val;
    Node next;

    Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  private Node[] bucket;

  private final int DEFAULT_CAPACITY = 2048;



  public J706_DesignHashMap() {
    bucket = new Node[DEFAULT_CAPACITY];
  }

  public void put(int key, int value) {
    Node p = find(key);
    if (p != null) {
      p.val = value;
      return;
    } else {
      p = bucket[key % DEFAULT_CAPACITY];
      if (p == null) {
        bucket[key % DEFAULT_CAPACITY] = new Node(key, value);
        return;
      } else {
        Node pre = null;
        while (p != null && p.key != key) {
          pre = p;
          p = p.next;
        }
        pre.next = new Node(key, value);
      }
    }
  }

  public int get(int key) {
    Node p = find(key);

    return p == null ? -1 : p.val;
  }

  public void remove(int key) {
    Node p = find(key);
    if (p != null) {
      Node pre = findPre(key);
      if (pre != null) {
        pre.next = p.next;
      } else {
        bucket[key % DEFAULT_CAPACITY] = p.next;
      }
    }
  }


  // if not exist, return null
  private Node find(int key) {
    Node p = bucket[key % DEFAULT_CAPACITY];
    while (p != null && p.key != key) p = p.next;

    return p;
  }

  // exist, and return pre
  // case key 是桶内第一个元素, pre = null
  // 否则 pre 一定非空
  private Node findPre(int key) {
    Node p = bucket[key % DEFAULT_CAPACITY];
    Node pre = null;
    while (p != null && p.key != key) {
      pre = p;
      p = p.next;
    }

    return pre;
  }
}

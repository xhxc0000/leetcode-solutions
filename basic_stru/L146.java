class LRUCache {

    private Map<Integer, LinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private LinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new LinkedNode();
        tail = new LinkedNode();
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            this.moveToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            node = new LinkedNode(key, value);
            this.cache.put(key, node);
            this.addToHead(node);
            
            count++;

            if (count > capacity) {
                LinkedNode eliminate = this.popTail();
                cache.remove(eliminate.key);
                count--;
            }
        } else {
            // update val;
            node.value = value;
            this.moveToHead(node);
        }
    }


    class LinkedNode {
        int key;
        int value;
        LinkedNode pre;
        LinkedNode post;

        public LinkedNode() {}
        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    /**
    * add the new node to right after head;
    */
    private void addToHead(LinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void remove(LinkedNode node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    private LinkedNode popTail() {
        LinkedNode res = tail.pre;
        this.remove(res);
        return res;
    }

    private void moveToHead(LinkedNode node) {
        this.remove(node);
        this.addToHead(node);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

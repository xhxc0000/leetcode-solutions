/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>(); // node -> clone
        return dfs(node, map);
    }

    private Node dfs(Node root, Map<Node, Node> map) {
        if (root == null) return null;
        if (map.containsKey(root)) return map.get(root);

        Node clone = new Node(root.val);
        map.put(root, clone);
        for (Node node : root.neighbors) {
            clone.neighbors.add(dfs(node, map));
        }

        return clone;
    }
}

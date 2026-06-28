/*
Definition for a Node.
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
        if (node == null) return null;
        Map<Node, Node> nodeMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node newNode = new Node(node.val);
        nodeMap.put(node, newNode);
        queue.add(node);
       
        while (!queue.isEmpty()) {
            Node currOrigin = queue.poll();
            Node currNew = nodeMap.get(currOrigin);
            for (Node n : currOrigin.neighbors) {
                if (!nodeMap.containsKey(n)) {
                    Node newN = new Node(n.val);
                    currNew.neighbors.add(newN);
                    queue.add(n);
                    nodeMap.put(n,newN);
                } else {
                     currNew.neighbors.add(nodeMap.get(n));
                }
            }
        }

        return newNode;
    }
}
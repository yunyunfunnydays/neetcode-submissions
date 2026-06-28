/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    private static final String NN = "n";
    private static final String SPLITTER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // use preorder path to serialize root
        StringBuilder sb = new StringBuilder();
        buildingString(root, sb);
        return sb.toString();
    }

    private void buildingString(TreeNode root, StringBuilder sb) {
        if (root == null){
            sb.append(NN).append(SPLITTER);
        } else {
            sb.append(root.val).append(SPLITTER);
            buildingString(root.left, sb);
            buildingString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(SPLITTER);
        Queue<String> nodes = new LinkedList<>(Arrays.asList(s));
      
        return buildTree(nodes);
    }
    private TreeNode buildTree(Queue<String> nodes){
        if(nodes.size() == 0) return null;

        String node = nodes.poll();
        if(node.equals(NN)) return null;

        TreeNode root =  new TreeNode(Integer.parseInt(node));
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;
    }
}

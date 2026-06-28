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

class Solution {
    public boolean isValidBST(TreeNode root) {
       List<Integer> values = new ArrayList<>();
       inOrder(root, values);
       for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) >= values.get(i + 1)) {
                return false;
            }
       }
       return true;
    }
    private void inOrder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        inOrder(root.left, values);
        values.add(root.val);
        inOrder(root.right, values);
    }
    
}

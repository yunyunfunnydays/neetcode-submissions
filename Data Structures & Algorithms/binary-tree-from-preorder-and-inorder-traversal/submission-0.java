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

// first node in preorder is root
// in inorder, node before root is on the left, after foot is on the right

class Solution {
    Map<Integer,Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // base case
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // build inorder map : easier to find index of number
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        // return result from build
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
            

    }

    private TreeNode build(int[] preorder,int preStart, int preEnd,
                            int[] inorder,int inStart, int inEnd) {

        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        // root = first item in preorder
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // find index of root in inorder
        int inorderIndex = inorderMap.get(root.val);
        int leftNodeNumber = inorderIndex - inStart;
        int rightNodeNumber = inEnd - inorderIndex;
        // recursive
             // [0, index) :left subtree
            // (index,n} : right subtree
        root.left = build(preorder, preStart + 1, preStart + leftNodeNumber,
        inorder, inStart, inStart + leftNodeNumber);
        root.right = build(preorder, preStart + leftNodeNumber + 1, preEnd,
        inorder, inorderIndex + 1, inEnd);

        // return root 
        return root;
    }

}

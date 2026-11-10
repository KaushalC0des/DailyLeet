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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }
    
    private TreeNode helper(int[] preorder, int preStart, int preEnd, 
                            int[] inorder, int inStart, int inEnd, 
                            HashMap<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inorderMap.get(root.val);
        int numsLeft = inIndex - inStart;
        
        root.left = helper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inIndex - 1, inorderMap);
        root.right = helper(preorder, preStart + numsLeft + 1, preEnd, inorder, inIndex + 1, inEnd, inorderMap);
        
        return root;
    }
}
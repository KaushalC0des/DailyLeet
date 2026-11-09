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

// we can solve question recursively also we have to take left and right node of tree and run this function recursvely and swap the left and right nodes 
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            final TreeNode node = queue.poll();
            
            final TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left !=null) queue.add(node.left);
            if(node.right !=null) queue.add(node.right);



        }
        return root;

    }
}   
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
public class Solution {
     int diameter = 0; // Member variable to store the diameter

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter; // Return the calculated diameter
    }

     int helper(TreeNode node) {
        if (node == null) return 0; // Base case: if node is null, return 0

        int leftDepth = helper(node.left);   // Get depth of left subtree
        int rightDepth = helper(node.right); // Get depth of right subtree

        // Calculate diameter at this node (number of edges)
        int currentDiameter = leftDepth + rightDepth;

        // Update the maximum diameter found so far
        diameter = Math.max(diameter, currentDiameter);

        // Return the depth of this subtree
        // diameter will use to compare previous diameter with current diameter/mn
       return  Math.max(leftDepth, rightDepth) + 1;
    }
}
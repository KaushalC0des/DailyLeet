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
 // offer is used to add the elements to queue
class Solution {
    public int minDepth(TreeNode root) {
       if(root == null) {
        return 0;
       }
       int depth = 1;
       Queue<TreeNode> q = new LinkedList<TreeNode>();
       q.offer(root);

       // level order traversal
       while(!q.isEmpty()){
        int size = q.size();
        for(int i=0; i<size; i++){
           TreeNode node = q.poll();

           if(node.left == null && node.right == null){
            return depth;
           }
           if(node.left != null){
            q.offer(node.left);
           }
           if(node.right != null){
            q.offer(node.right);
           }
        }
        depth++;
       }
       return depth;
    }
}
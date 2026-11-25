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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        levelQueue.add(null);

        List<Double> avgList = new ArrayList<>();

        while(levelQueue.peek() != null){
            double sum = 0;
            int nodes = 0;
            while(levelQueue.peek() != null){
                TreeNode node = levelQueue.poll();
                sum += node.val;
                 nodes++;
                if(node.left!=null) levelQueue.add(node.left);
                if(node.right!=null) levelQueue.add(node.right);
                 
            }
            // this step is to add nullback again to queue because queue follows fifo property so firs element will polled and again added toi the queue and its null only
                levelQueue.add(levelQueue.poll());
                avgList.add(sum/nodes);
   
        }
         return avgList;
    }
}


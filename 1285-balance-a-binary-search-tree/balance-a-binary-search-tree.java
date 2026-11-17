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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder); 
        int n = inorder.size() - 1;
        return createBST(0, n, inorder);
    }

    private TreeNode createBST(int st, int end, ArrayList<Integer> inorder) {
        if (st > end) {
            return null;
        }
        int mid = st + (end - st) / 2; 
        TreeNode root = new TreeNode(inorder.get(mid)); 
        
       
        root.left = createBST(st, mid - 1, inorder); 
        root.right = createBST(mid + 1, end, inorder); 
        return root;
    }

    public void getInorder(TreeNode root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.val); 
        getInorder(root.right, inorder);
    }
}
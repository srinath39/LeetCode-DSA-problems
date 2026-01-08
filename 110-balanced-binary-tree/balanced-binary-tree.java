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
    public boolean isheightBalanced;
    public boolean isBalanced(TreeNode root) {
        isheightBalanced=true;
        maxDepth(root);
        return isheightBalanced;
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        int x=maxDepth(root.left);
        int y=maxDepth(root.right);
        if(Math.abs(x-y)>1){
            isheightBalanced=false;
        }
        return Math.max(x,y)+1;
    }
}
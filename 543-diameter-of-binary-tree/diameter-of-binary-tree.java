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
    public static int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max=0;
        diameterOfBTree(root);
        return max;
    }

    public int diameterOfBTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int x=diameterOfBTree(root.left);
        int y=diameterOfBTree(root.right);
        max=Math.max(max,x+y);
        return Math.max(x,y)+1;
    }
}
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //dfs problem 
        return dfs(root, 0, targetSum);
    }
    private boolean dfs(TreeNode node, int currSum, int target) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            if(currSum + node.val == target) {
                return true;
            }
        }
        return (dfs(node.left, currSum + node.val, target) 
            || dfs(node.right, currSum + node.val, target));
    }
}
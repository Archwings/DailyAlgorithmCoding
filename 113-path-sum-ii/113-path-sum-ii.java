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
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // DFS through the tree, can do it recurrsivly, using the current sum at node seen so far
        List<Integer> currList; 
        DFS(root, 0, targetSum, currList = new ArrayList<>());
        return list;
    }
    
    private void DFS(TreeNode node, int currSum, int target, List<Integer> currRoute) {
        if (node == null) {
            return;
        }
        currRoute.add(node.val);
        if (node.val + currSum == target && node.left == null && node.right == null) {
            list.add(new ArrayList<>(currRoute));
        }
        
        DFS(node.left, currSum+node.val, target, currRoute);
        DFS(node.right, currSum+node.val, target, currRoute);
        
        // removes nodes that did not lead to desired path (backtracking)
        currRoute.remove(currRoute.size()-1);
    }
}
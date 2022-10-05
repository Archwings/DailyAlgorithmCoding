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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // BFS till we reach depth -1, create new L and R nodes for each node in the queue at depth - 1, connect the tree with its existing left and right subtrees if they exist. If they dont exist, create leaves with no children. Enqueue the next TreeNodes if we havent reached depth -1 yet.
        
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        queue.offer(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            int currDepth = pair.getValue();
            TreeNode node = pair.getKey();
            if (currDepth == depth - 1) {
                if (node.left != null) {
                    node.left = new TreeNode(val, node.left, null);
                } else {
                    node.left = new TreeNode(val, null, null);
                }
                if (node.right != null) {
                    node.right = new TreeNode(val, null, node.right);
                } else {
                    node.right = new TreeNode(val, null, null);
                }
            }
            else {
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, currDepth + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, currDepth + 1));
                }
            }
        }
        return root;
    }
}
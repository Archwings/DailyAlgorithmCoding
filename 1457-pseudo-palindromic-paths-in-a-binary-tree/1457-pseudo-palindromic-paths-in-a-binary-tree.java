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
    private int count = 0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        // DFS question for whenever we hit a leaf node. Recurssively traverse through the tree keeping the stored values in a hashmap, copying it into a new map whenever we visit a child node to keep track of count. When we reach a leaf node, check if the map contains 2 of eavery entry except one of them and add to the count.
        HashMap<Integer, Integer> map = new HashMap<>();
        DFS(root, map);
        return count;
    }
    
    private void DFS(TreeNode node, HashMap<Integer, Integer> map) {
        if (node == null) return;
        map.put(node.val, map.getOrDefault(node.val, 0)+1);
        
        DFS(node.left, new HashMap(map));
        DFS(node.right, new HashMap(map));
        
        if (node.left == null && node.right == null) {
            int check = 0;
            Iterable<Integer> setVal = map.values();
            Iterator<Integer> iterator = setVal.iterator();
            while (iterator.hasNext()) {
                int val = iterator.next();
                if (val % 2 == 1) {
                    check++;
                }
                if (check > 1) {
                    break;
                }
                
                if (!iterator.hasNext()) {
                    count++;
                }
                
            }
        }
        
        
    }
}
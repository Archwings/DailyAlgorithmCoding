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
    public int countNodes(TreeNode root) {
        // get the height of the binary tree, then binary search using how many nodes exist on that layer height if that level were complete
        // once we find the furthest bottom right node, use math to add up all the nodes 
        
        // find height
        int height = 0;
        TreeNode node = root;
        if (root == null) return 0;
        while (node.left != null) {
            height++;
            node = node.left;
        }
        if (height == 0) {
            return 1;
        }
        int right = (int) Math.pow(2, height)-1;
        int left = 1;
        
        while (left <= right) {
            int mid = left + (right - left)/2;
            
            if (doesExist(root, mid, height)) {
                left = mid + 1;
                System.out.println(left);
                System.out.println(right);
            } else {
                right = mid - 1;
                System.out.println(left);
                System.out.println(right);
            }
        }
        //calculate the max with left
        return (int) ((Math.pow(2, height) - 1) +  left);
    
    }
    private boolean doesExist(TreeNode root, int index, int height) {
        //int curr = (int) (Math.pow(2, height))/2;
        System.out.println(index + " " +"index");
        int currLv = 0;
        int bottomNodeCount = (int) Math.pow(2, height);
        int curr =  bottomNodeCount / 2; 
        while (currLv != height) {
            System.out.println(curr + " " +"curr");
            if (index >= curr) {
                // index is on the right branch
                root = root.right;
                currLv++;
                curr = curr + (bottomNodeCount /(int) (Math.pow(2, currLv+1))); 
            } else {
                // index is on the left branch
                currLv++;
                curr = curr - (bottomNodeCount /(int) (Math.pow(2, currLv+1)));
                root = root.left;
            }
        }
        //System.out.println(currLv + "currlevel");
        System.out.println(root +" "+ index);
        return (root != null);
    }
}
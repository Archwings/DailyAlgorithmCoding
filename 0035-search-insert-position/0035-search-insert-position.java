class Solution {
    public int searchInsert(int[] nums, int target) {
        // binary search to find where to put it
        int left = 0;
        int right = nums.length-1;
        
        while (left <= right) {
            int mid = left +(right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
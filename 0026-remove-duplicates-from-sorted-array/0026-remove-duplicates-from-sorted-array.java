class Solution {
    public int removeDuplicates(int[] nums) {
        //two pointers 
        int length = nums.length;
        int left = 0; 
        int right = 0;
        
        while (right < length) {
            while (right + 1 < length && nums[right] == nums[right+1]) {
                right++;
            } 
            nums[left] = nums[right];
            right++;
            left++;
        }
        return left;
    }
}
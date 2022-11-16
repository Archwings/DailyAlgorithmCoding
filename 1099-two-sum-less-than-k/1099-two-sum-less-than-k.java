class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        // Sort the nums array. Using two pointers, one at index 0 and the other at index nums.length, move the pointers depending on the sum of the integers pointed to. Keep track of the highest sum under k.
        // If the sum > k, move the right pointer by a index,
        // If sum < k, move the left pointer by an index higher.
        int biggestSum = -1;
        Arrays.sort(nums);
        int left = 0; 
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                biggestSum = Math.max(biggestSum, sum);
                left++;
            } else{
                right--;
            }
        }
        return biggestSum;
    }
}
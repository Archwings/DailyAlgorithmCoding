class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // sliding window containing a single 0
        int highestCount = 0;
        int zeroCount = 0;
        int left = 0;
        for (int i = 0 ; i < nums.length; i++) {
            
            if (nums[i] == 0) {
                zeroCount++;
            }
            while (zeroCount == 2) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            highestCount = Math.max(highestCount, i - left + 1);
        }
        return highestCount;
    }
}
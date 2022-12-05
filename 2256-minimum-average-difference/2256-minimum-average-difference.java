class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        long[] leftSide = new long[nums.length];
        long[] rightSide = new long[nums.length];
        int length = nums.length;
        leftSide[0] = nums[0];
        int minAvgDiff = Integer.MAX_VALUE;
        int minInd = Integer.MAX_VALUE;
        
        if (length == 1) {
            return 0;
        }
        for (int i = 1; i < length; i++) {
            leftSide[i] = leftSide[i-1] + nums[i];
        }
        for (int i = 1; i < length; i++) {
            leftSide[i] = leftSide[i] / (i+1);
        }
        
        rightSide[length-1] = 0;
        for (int i = nums.length-2; i >= 0; i--) {
            rightSide[i] = rightSide[i+1] + nums[i+1];
        }
        
        
        for (int i = 1; i < length; i++) {
            rightSide[length-1-i] = rightSide[length-1-i] / (i);
        }
        
        
        for (int i = length-1; i >= 0; i--) {
            int currAvgDiff = (int) Math.abs(leftSide[i] - rightSide[i]);
            if (currAvgDiff <= minAvgDiff) {
                minAvgDiff = currAvgDiff;
                if (i < minInd) {
                    minInd = i;
                }
            }
            
        }
        
        return minInd;
    }
}
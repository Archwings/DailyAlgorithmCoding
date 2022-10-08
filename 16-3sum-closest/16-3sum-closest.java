class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int ptr1 = i + 1;
            int ptr2 = nums.length-1;
            while (ptr1 < ptr2) {
                int sum = nums[ptr1] + nums[ptr2] + nums[i];
                if (Math.abs(target-sum) < Math.abs(res)) {
                    res = target-sum;
                }
        
                if (sum < target) {
                    ptr1++;
                } else {
                    ptr2--;
                }
            }
        }
        return target - res;                             
    }
}
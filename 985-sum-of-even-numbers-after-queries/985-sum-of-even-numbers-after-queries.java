class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        // naive approach
        // int[] res = new int[queries.length];
        // int queryInd = 0;
        // for (int[] query : queries) {
        //     nums[query[1]] += query[0];
        //     int sum = 0;
        //     for (int i = 0; i < nums.length; i++) {
        //         if (nums[i] % 2 == 0) {   
        //             sum += nums[i];
        //         }
        //     }
        //     res[queryInd] = sum;
        //     queryInd++;
        // }
        // return res;
        
        int[] res = new int[queries.length];
        int queryInd = 0;
        int currSum = 0;
        for (int ind: nums) {
            if (ind % 2 == 0) {
                currSum += ind;
            }
        }
        
        for (int[] query : queries) {
            int newVal = nums[query[1]] + query[0];
            //nums is index is even
            if (nums[query[1]] % 2 == 0) {   
                if (newVal % 2 == 0) {
                    //currSum -= nums[query[1]];
                    currSum += newVal;
                }
                currSum -= nums[query[1]];
            } else {
                // nums index is odd
                if (newVal % 2 == 0) {
                    currSum +=  newVal;
                }   
            }
            nums[query[1]] += query[0];
            res[queryInd] = currSum;
            queryInd++;
        }
        return res;
        
    }
}
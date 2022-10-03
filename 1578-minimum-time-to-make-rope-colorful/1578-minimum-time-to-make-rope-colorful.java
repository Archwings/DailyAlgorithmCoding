class Solution {
    public int minCost(String colors, int[] neededTime) {
        // Using two pointers, iterate through the list from left to right, with the second pointer being 1 away from the first pointer. If the balloon is the same color, move the second pointer along until the next balloon is a different color. While doing this, keep track of the highest 'neededTime' in the window between the left and right pointers. If a higher value is found we will keep this value. Remove every balloon that is not the one pointed to in the window of balloons
        if (neededTime.length == 0 || neededTime.length == 1) {
            return 0;
        }
        int ans = 0;
        int first = 0;
        int second = 0;
        
        while (second < neededTime.length) {
            int currMax = 0;
            int totalMax = 0;
            while (second < neededTime.length && colors.charAt(first) == colors.charAt(second)) {
                totalMax += neededTime[second];
                currMax = Math.max(currMax, neededTime[second]);
    
                second++;
            }
            ans += totalMax;
            ans -= currMax;
            first = second;
        }
        return ans;
    }
}
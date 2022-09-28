class Solution {
    public String pushDominoes(String dominoes) {
        // Appraoch 1: iterate throught the dominos from left to right, and update the neighbours from the corresponding 'L' or 'R' dominoes. do this n times, until the dominos next frame stays the same. Time complexity: n^2 space: n to store the string of dominos Assuming this is not optimal.
        // Approach 2: iterate throught the dominoes from left to right, if you hit a domino pushed left, update all previously standing dominoes. If you reach a domino pushing to the right, search for the next left pushing domino in the string list. take the index of that domino and minus the index of the right pushed domino, if the difference is odd, there will exist a standing domino in the middle, divide the difference by 2 and minus 1 to update each domino to the right of the right pushed by that amount and the same for the left pushed domino. If you reach a domino pushing to the right again when searching, update the previous dominos to fall right and set a pointer to remember the place of the new right pushed domino. This solution is still O(n^2) 
//         int rightPushed = 0; 
//         int standPrevCount = 0;
//         int length = dominoes.length()-1;
//         int toPush = 0;
        
//         StringBuilder build = new StringBuilder(dominoes);
        
//         for (int i = 0; i < dominoes.length(); i++) {
//             if (dominoes.charAt(i) == '.') {
//                 standPrevCount++;
//                 continue;
                
//             } else if (dominoes.charAt(i) == 'L') {
//                 for(int j = i - standPrevCount; j < i; j++) {
//                     build.replace(j, j+1, "L");
//                 }
//             } else if (dominoes.charAt(i) == 'R') {
//                 standPrevCount = 0;
//                 rightPushed = i;
//                 while(i != length) {
//                     i++;
//                     if (dominoes.charAt(i) == 'L') {
//                         break;
//                     }
//                     standPrevCount++;
//                     if (dominoes.charAt(i) == 'R') {
//                         for (int l = rightPushed; l < i; l++) {
//                             build.replace(l, l+1, "R");
//                         }
//                         standPrevCount = 0;
//                         rightPushed = i;
//                     }
//                 }
//                 if (i == length) {
//                     for (int l = i-standPrevCount+1; l < i+1; l++) {
//                         build.replace(l, l+1, "R");
//                     }
//                 }
//                 if (dominoes.charAt(i) == 'L') {
//                     toPush = standPrevCount /2;
//                     for (int k = rightPushed; k <= rightPushed + toPush; k++) {
//                         build.replace(k, k+1, "R");

//                     }
//                     for (int k = i; k >= i - toPush; k--) {
//                         build.replace(k, k+1, "L");
//                     }   
//                 }
//                 standPrevCount = 0;
//             }
//         }
//         return build.toString();
        
        // Approach 3: 4 case solution while keeping track of last seen R and L
        // Case 1: you see R and R > L turn every dot to R, seen as R...R
        // Case 2: you see R and R < L seen as L...R -> dont do anything
        // Case 3: you see L and L > R seen as L...L -> turn every dot to L
        // Case 4: you see L and R > L seen as R...L -> have pointers from both sides, hi and lo, increment lo and decrement high, and set the values in your array ensuring the condition that lo < hi. stop otherwise
        char[] array = dominoes.toCharArray();
        for (int i = 0, L = -1, R = -1; i <= dominoes.length(); i++) {
            if (i == array.length || array[i] == 'R') {
                if (R > L) { // Case 1 and end case
                    while (R < i) {
                        array[R++] = 'R';
                    }
                }
                R = i;
            } else if (array[i] == 'L'){
                if (L > R || R == -1) { // Case 3 and start case
                    while (L < i) {
                        L++;
                        array[L] = 'L';
                    }
                } else if (R > L) { // Case 4
                    L = i;
                    int hi = L-1, lo = R+1;
                    while (hi > lo) {
                        array[lo] = 'R';
                        array[hi] = 'L';
                        hi--;
                        lo++;
                    }
                }
            }
        }
        return new String(array);
     }
}
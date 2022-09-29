class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if (arr.length == k) {
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            return list;
        }
        int closestInd = getClosestIndex(arr, x);
        // get the closest index and check its neighbors to see which index has a closer element, add it to the window.
        
        int left = closestInd-1;
        int right = closestInd;
        while(right - left -1 < k) {
            if (left == -1) {
                right++;
            } else {
                if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    // include left
                    left--;
                } else {
                    right++;
                }
            }
        }
        for (int i = left + 1; i < right; i++) {
            list.add(arr[i]);
        }
        return list;
        
        
    }
    // binary search
    private int getClosestIndex(int[] arr, int x) {
        int left = 0;
        int right = arr.length-1;
        int half = right/2;
        while (left < right) {
            half = left + ((right-left)/2);
            if (arr[half] < x) {
                left = half+1;
            } else { // arr[half] >= x
                right = half;
            }
        }
        System.out.println(half);
        return left;
    }
}
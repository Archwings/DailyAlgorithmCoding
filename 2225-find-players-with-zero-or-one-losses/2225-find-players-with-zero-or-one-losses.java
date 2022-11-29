class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // Hash Map solution where we add each player and each time they lose a match, increment a counter value stored in the hashmap. At the end, create a list of the player values looking for players who lost one or no matches.
        
        /// Time complexity: 
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int length = matches.length;
        
        List<List<Integer>> list = new ArrayList<>();
        
        //get the player count;
        int playerCnt = 0;
        for (int i = 0; i < length; i++) {
            playerCnt = Math.max(playerCnt, matches[i][0]);
            playerCnt = Math.max(playerCnt, matches[i][1]);
        }
       
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(matches[i][0])) {
                map.put(matches[i][0], 0);
            }
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0)+1);
        }
        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        
        Iterator<Integer> keyIterator = map.keySet().iterator();
        Iterator<Integer> valIterator = map.values().iterator();
        
        while(valIterator.hasNext()) {
            int lossCount = valIterator.next();
            int player = keyIterator.next();
            
            if (lossCount == 0) {
                zeroLoss.add(player);
            }
            if(lossCount == 1) {
                oneLoss.add(player);
            }
        }
        list.add(zeroLoss);
        list.add(oneLoss);
        return list;
    }
}
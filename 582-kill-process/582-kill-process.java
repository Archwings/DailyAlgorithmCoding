class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        //adjacency list with a hashmap implementation
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ppid.size(); i++) {
            // gets the parent node, and puts the child in the list
            List<Integer> l = map.getOrDefault(ppid.get(i), new ArrayList<Integer>());
            l.add(pid.get(i));                                   
            map.put(ppid.get(i), l); 
        }
        
        list.add(kill);
        dfs(map, list, kill);
        System.out.println(map.toString());
        return list;
    }
    private void dfs(HashMap<Integer, List<Integer>> map, List<Integer> list, int kill) {
        if (map.containsKey(kill)) {
            List<Integer> sub = map.get(kill);
            for (int i = 0; i < sub.size(); i++) {
                list.add(sub.get(i));
                dfs(map, list, sub.get(i));
            }
        }
    }
}
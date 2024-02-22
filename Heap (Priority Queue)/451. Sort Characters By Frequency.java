class Solution {
    /*
    maxheap to store all the characters according to their frequency

    */
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c: s.toCharArray()){
           map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue((s1, s2) -> map.get(s2) - map.get(s1) );
        pq.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char curr = pq.poll();
            for(int i = 0; i < map.get(curr); i ++){
                sb.append(curr);
            }
        }
        return sb.toString();

    }
}
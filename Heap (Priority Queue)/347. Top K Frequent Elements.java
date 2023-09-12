class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //maxheap
        PriorityQueue<Integer> pq = new PriorityQueue((a,b) -> map.get(a) - map.get(b));

        //keep top k frequent elements in the heap
        for(int n: map.keySet()){
            pq.add(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for(int i = k-1; i>=0; i--){
            ans[i] = pq.poll();
        }
        return ans;
    }
}
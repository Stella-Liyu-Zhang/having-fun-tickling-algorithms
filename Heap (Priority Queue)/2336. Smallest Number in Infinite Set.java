class SmallestInfiniteSet {
    /*
    minHeap, 
    */
    PriorityQueue<Integer> pq;
    int currMin;
    HashSet<Integer> isPresent;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue();
        currMin = 1;
        isPresent = new HashSet();
    }
    
    public int popSmallest() {
        int ans = 0;
       if(pq.isEmpty() == false){
            ans = pq.poll();
            isPresent.remove(ans);
       }else{
           ans = currMin;
           currMin ++;
       }
       return ans;
    }
    
    public void addBack(int num) {
        if(isPresent.contains(num) || currMin <= num){
            return;
        }
        isPresent.add(num);
        pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
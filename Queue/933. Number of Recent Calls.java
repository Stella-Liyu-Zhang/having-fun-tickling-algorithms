class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        //add the current call at the end of the queue
        queue.offer(t);
        //peek() is to get the first element (at front)
        //poll() is to remove the first at the front
        while(queue.peek() < t - 3000){
            queue.poll();
        }
        return this.queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
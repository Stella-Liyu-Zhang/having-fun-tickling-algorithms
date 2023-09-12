class Solution {
    public int minMeetingRooms(int[][] intervals) {
        /*Use a minHeap to track the earliest ending meeting at any time
            new meeting, check if there are conflict with the earliest ending meeting
        */
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        //sort the meetings by their starting time in ascending order
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] );
        //the root of the minheap always track the meeting that ends earliest
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        minHeap.add(intervals[0]);
        //need to start from the second meeting
        for(int i = 1; i < intervals.length; i ++){
            int[] curr = intervals[i];
            int[] endsEarliest = minHeap.remove();
            if(curr[0] >= endsEarliest[1]){ //must be >=, because if the end time == start time, we only need 1 meeting room. 
                endsEarliest[1] = curr[1];
            }else{
                minHeap.add(curr);
            }
            minHeap.add(endsEarliest);
        }
        return minHeap.size();
    }
}
public int minMeetingRooms(int[][] intervals) {
    if (intervals.length == 0){
            return 0;
    }
    Arrays.sort(intervals, (s1,s2) -> Integer.Compare(s1[0], s2[0]));
    PriorityQueue<Integer> pq = new Queue<>();
    int rooms = 0;
    for(int i = 0; i < intervals.length; i ++){
            pq.offer(intervals[i][1]);
            if (intervals[i][0] < pq.peek()){
                    rooms ++;
            }else{//no overlaps exist
                    pq.poll();
            }
    }

    return rooms;
}
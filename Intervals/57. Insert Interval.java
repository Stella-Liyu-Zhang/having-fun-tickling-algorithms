class Solution {
    /*
    intevals sorted in ascending by start
    [2,5]
    [[1,3],[6,9]]
    [[1,5], [4,6] [7, 9]]
    [1,5]

    [3,5],[6,7],
    [4,8]
    O(N)
    O(1)
    THE Starting pointer of intervals <= new interval's ending point
    */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList();
        int size = intervals.length;

        int pointer = 0;

        while(pointer < size && intervals[pointer][1] < newInterval[0]){
            list.add(intervals[pointer]);
            pointer ++;
        }
        while(pointer < size && intervals[pointer][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[pointer][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[pointer][1]);
            pointer ++;
        }
        list.add(newInterval);
        while(pointer < size){
            list.add(intervals[pointer]);
            pointer ++;
        }
        return list.toArray(new int[list.size()][]);
        
    }
}
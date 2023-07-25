class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        Visit every single interval in the arraylist
        keep updating the new interval itself
        expand the intervals big, wide enough so that everything else still remains as original intervals.
        */
        //Make a new container
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i++]);
        }
        while (i < n && intervals[i][0] <= newInterval[1]){
            newInterval = new int []{
                Math.min(intervals[i][0], newInterval[0]),
                Math.max(intervals[i][1], newInterval[1])
            };
            i++;
        }
        result.add(newInterval);
        while(i < n ){
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}
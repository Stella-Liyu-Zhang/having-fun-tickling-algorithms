class Solution {
    /*
    Time: O(nlogn)
    Space: O(1)
    */
    public boolean canAttendMeetings(int[][] intervals) {
        //Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b [0]));
        for(int i = 1; i < intervals.length; i ++){
            if (intervals[i-1][1] > intervals[i][0]){
                return false;
            }
        }
        return true;
    }
}
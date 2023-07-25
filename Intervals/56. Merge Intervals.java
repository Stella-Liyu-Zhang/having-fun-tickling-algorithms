class Solution {
    /*
    Brute force: O(n^2)


    */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        ArrayList<int[]> output = new ArrayList<>();

        int[] curr = intervals[0];
        output.add(curr);

        for(int[] intv: intervals){
            if (intv[0] <= curr[1]){
                curr[1] = Math.max(curr[1], intv[1]);
            }else{
                curr = intv;
                output.add(curr);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}
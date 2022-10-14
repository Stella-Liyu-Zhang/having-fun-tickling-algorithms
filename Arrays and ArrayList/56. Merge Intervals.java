class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // sort the intervals array according to the first index of each interval
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int[] curr = intervals[0];
        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(curr);

        for (int[] intv : intervals) {
            if (intv[0] <= curr[1]) { // Overlapping intervals, move the end if needed
                curr[1] = Math.max(curr[1], intv[1]);
            } else { // Disjoint intervals, add the new interval to the list
                curr = intv;
                ans.add(curr);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
import java.util.HashMap;

/*
 * Given an m x n matrix mat where every row is sorted in strictly increasing order, 
 * return the smallest common element in all rows.

    If there is no common element, return -1.

    Example 1:

    Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
    Output: 5
    Example 2:

    Input: mat = [[1,2,3],[2,3,4],[2,3,5]]
    Output: 2
    Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n <= 500
    1 <= mat[i][j] <= 104
    mat[i] is sorted in strictly increasing order.
 */
/*
 * Solution 1: Hashmap
 * 1) @key: mat[i][j]
 *    @value: occurence
 * 2) loop through the set of keys,
 *      - if key's corresponding value == n
 *      - get the min of these
 * 
 * 时间O(mn), 空间O(n
 */
class Solution {
    public int smallestCommonElement(int[][] mat) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                hm.put(mat[i][j], hm.getOrDefault(mat[i][j], 0) + 1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int key : hm.keySet()) {
            if (hm.get(key) == n) {
                min = Math.min(min, key);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

/**
 * 
 */

class Solution {
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i : mat[0]) {
            boolean found = true;
            for (int j = 0; j < m; j++) {
                if (!helper(mat[j], i)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }

    private boolean helper(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] > target) {
                right = mid - 1;
            } else if (row[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
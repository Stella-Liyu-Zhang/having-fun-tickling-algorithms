class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0;
        int maxCount = 00;

        for (char c : tasks) {
            count[c - 'A']++;
            if (count[c - 'A'] == max) {
                maxCount++;
            } else if (count[c - 'A'] > max) {
                max = count[c - 'A'];
                maxCount = 1;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
    }
}
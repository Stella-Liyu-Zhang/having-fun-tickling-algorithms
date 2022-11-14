class Solution {
    /*
     * So arr[i] positive means t is deficient of those characters and they need to
     * be added to make it same
     * arr[i] is negative means t is in surplus of those characters and they need to
     * be replaced. a
     * 
     * you could have done if(arr[i] < 0 ) ans+=arr[i] and then returned -1*ans as
     * well and it would have resulted in same ans
     * 
     * consider an example abcde and aaabd
     * 
     * so your array will look like [-2,0,1,0,1]
     * so you can see that sum of negative and postive is always the same
     * 
     */
    public int minSteps(String s, String t) {
        int[] charArr = new int[26];
        int steps = 0;
        for (int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i) - 'a']++;
            charArr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (charArr[i] > 0) { // if it's negative, not true, because we can't be adding negatives to our
                                  // steps.
                steps += charArr[i];
            }
        }
        return steps;
    }
}
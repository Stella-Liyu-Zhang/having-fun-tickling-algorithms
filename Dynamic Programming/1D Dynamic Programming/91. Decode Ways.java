class Solution {
    /*
    bottom up processing
    use all the sub-problems up to n to reach.

    dp[n] stores the maximum number of ways to decode the string of length n 

    if the string s is empty, return null;
    dp[0] = 1
    */
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0:1;
        for(int i = 2; i <= s.length(); i ++){
            int twoDigit = Integer.valueOf(s.substring(i-2,i));
            if(twoDigit <= 26 && twoDigit >= 10){
                dp[i] += dp[i-2];
            }
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
        }
        return dp[s.length()];

    }
}
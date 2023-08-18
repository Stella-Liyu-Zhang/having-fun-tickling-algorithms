class Solution {
    public int numDecodings(String s) {
        int ans = 0;
        // determine how many ways, use all the subproblems up to solve the nth problem
        // dp[i] will store the number of ways to decode s.
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (oneDigit > 0 && oneDigit < 10) {
                dp[i] += dp[i - 1];
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}

//Second attempt
class Solution {
    /*
    bottom up processing
    use all the sub-problems up to n to reach.

    dp[n] stores the maximum number of ways to decode the string up to n. 
    */
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0:1;
        for(int i = 2; i <= s.length(); i ++){
            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            if(oneDigit > 0 && oneDigit <= 9){
                dp[i] += dp[i-1];
            }
            //don't need an else statement, because we would add twice if both works
            if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
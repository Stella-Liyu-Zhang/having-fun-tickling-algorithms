class Solution {
    /*
    cache, save redundant calculations
    boolean[size + 1], calculate every single substring of the array, substring begins at inclusive, end index is exclusive
    boolean[i], fom a position to end in index 1, if it's possible to break the string up to this word 
     booleann[i] = 0
     s.substring(j, i) == 'LEET', set boolean[i] = true

    j always smaller than i, to ensure that substring length is at least 1

    optimization
    get the max length of all the words in the dictionary
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        int maxLen = 0;
        for(String str: wordDict){
            maxLen = Math.max(str.length(), maxLen);
        }
        for(int i = 0; i <= n; i ++){
            for(int j = i-1; j >= 0; j --){
                if(i-j > maxLen){
                    continue;
                }
                if(dp[j] == true && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[n];

    }
}
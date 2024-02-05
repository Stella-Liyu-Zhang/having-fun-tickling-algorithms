class Solution {
    /*
    Dynamic programming
    leetcode, ["leet", "code"]
    
    dp - most likely use smth extra to store the temorary state, save redundant calculation
    cache
    boolean array
    size of the length of string given + 1,
    because we need to calcualte all the substrings, substring(inclusive, exclusive)
    have the last 1 to be one more. 

    leetcode
    012345678
    FFFFFFFFF
    key to understand dp problem
    s.substring(j, i) = "LEET"
    IN THE DICTIONARY
    

    2 pointer
    begin ending index
    i fast
    j slow pointer
    when we find the substring, we will mark the ending N

    1)cache array method
    dp[] bool arr
    2) base case: true
    3) 
    leetcode | wordDict = ["leet","code"]
        i
     j
    T. T
    need to 
    optimization 1: check maxlen

    Time complexity: O(n^3) as substring operation takes o(N) time
    space: O(n)
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        int maxLen = 0;
        for(String word: wordDict){
            maxLen = Math.max(word.length(), maxLen);
        }
        dp[0] = true;
        //by default, all the other are false, empty array is always included in any word dictionary
        //two pointers, i and j
        for(int i = 0; i <= n; i ++){
            for(int j = i-1; j >= 0; j--){
                if(i - j > maxLen){
                    continue;
                }
                if(dp[j] == true && wordDict.contains(s.substring(j,i))){
                    dp[i] = true; //change ending to true
                }
            }
        }
        return dp[n];
    }
}
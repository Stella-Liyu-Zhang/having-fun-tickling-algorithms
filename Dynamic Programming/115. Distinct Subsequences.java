class Solution {
    /*
    Given two strings s and t, return the number of distinct subsequences of s which equals t.

    ACE is a subsequence of ABCDE

    brutal force: exponential 

    s = "rabbbit", t = "rabbit"
    we need t to be 100% matched


    dp[i][j]:= num of subsequence of S[1:j] equals T[1:i]

    Example:
    numSubSeq("babgba", "ba") = 4
                            ^^
                            ^          ^
                                ^     ^
                                    ^^
    numSubSeq("babgba", "bag") = 1
                        ^^    ^

    numSubSeq("babgba[g]", "ba[g]") = 4 + 1 = 5

    cache
    i len(s)*len(t)

    if s[i] == t[j]
        (i+1, j+1)
        (i+1, j)

    else
        (i+1, j)
    */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() +1];
        
        for(int j = 0; j <= s.length(); j ++){
            dp[0][j] = 1;
        }

        for(int i = 0; i < t.length(); i ++){
            for(int j = 0; j < s.length(); j ++){
                if(t.charAt(i) == s.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + dp[i+1][j];
                }else{
                    //skip s[j]
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
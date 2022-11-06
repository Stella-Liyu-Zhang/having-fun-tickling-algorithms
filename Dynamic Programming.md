## 96. Unique Binary Search Trees

The problem is to calculate the number of unique BST. To do so, we need to define two functions:

1. `G(n)`: the number of unique BST for a sequence of length n.
2. `F(i, n), 1 <= i <= n`: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
3. First of all, given the above definitions, we can see that the total number of unique BST G(n), is the sum of BST F(i) using each number i as a root.
   i.e.
   `G(n) = F(1, n) + F(2, n) + ... + F(n, n)`
4. Base casE: `G(0)=1, G(1)=1. `
5. `F(i, n) = G(i-1) * G(n-i) 1 <= i <= n `

Combining the above two formulas, we obtain the recursive formula for G(n). i.e.
`G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) `

```java
public int numTrees(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        int[] catalan = new int[n+1];
        catalan[0] = 1;
        catalan[1] = 1;
        for(int i = 2; i <= n; i ++){
            for(int j =0; j < i; j ++){
                catalan[i] += catalan[j] * catalan[i-j-1];
            }
        }
        return catalan[n];
}
···
```

## 91. Decode Ways

0 --> 1
s.length() == 1 --> 0
dp[i] --> ways to decode the string until length i

- s.substring(i-2,i) dp[i] += dp[i-2]
- s.substring(i-1,i) dp[i] += dp[i-1]

```java
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;
        for(int i = 2; i <= s.length(); i ++){
            int length1 = Integer.valueOf(s.substring(i-1,i));
            int length2 = Integer.valueOf(s.substring(i-2,i));
            if (length1 > 0 && length1 < 10){
                dp[i] += dp[i-1];
            }
            if (length2 >= 10 && length2 <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
```

## 62. Unique Paths

### Approach 1: DP

```java
public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] += dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
}
```

### Approach 2:

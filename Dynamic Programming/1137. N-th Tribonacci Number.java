// Better Dynamic Programming (Bottom Up)
class Solution {
    /*
    T0 = 0, T1 = 1, T2 = 1

    Tn+3 = Tn + Tn+1 + Tn+2 
    */
    public int tribonacci(int n) {
        if(n<2){
            return n;
        }
        if(n==2){
            return 1;
        }
        int a = 0, b = 1, c = 1;
        for(int i = 0; i < n-2; i ++){
            int temp = a+b+c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }
}

//Dynamic Programming (Bottom Up)
class Solution {
    /*
    T0 = 0, T1 = 1, T2 = 1

    Tn+3 = Tn + Tn+1 + Tn+2 
    */
    public int tribonacci(int n) {
        if(n<2){
            return n;
        }
        if(n==2){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i ++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
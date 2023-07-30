class Solution {
    /*
    the modulo operation is performed at multiple places to prevent integer overflow. The numbers involved in the computation can become very large, and Java's int data type has a limited range. When the result of an operation exceeds the maximum value that can be represented by an int, it wraps around and leads to incorrect results.
By applying the modulo operation at different stages of the computation, the values are kept within a manageable range. The value of mod is 1000000007, which is a prime number, and it's often used as the modulo in competitive programming to avoid collisions and distribute the numbers uniformly.


O(n), O(n)
    */
    public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {
        int mod = 1000000007;
        int[] dp = new int[maxLength + 1]; //dp[i] represents number of goodBS of length i
        dp[0] = 1; //Since 0 is a multiple of all numbers

        int result = 0;

        //you can add a oneGroup of 1's or a zeroGroup of 0's every time to extend the goodBS
        for(int i = 1; i <= maxLength; i ++){
            if (i >= oneGroup){
                dp[i] = (dp[i] + dp[i-oneGroup]) % mod;
            }
            if (i >= zeroGroup){
                dp[i] = (dp[i] + dp[i-zeroGroup]) % mod;
            }
            if (i >= minLength){
                result = (result + dp[i]) % mod;
            }

        }
        return result %mod;

    }
}
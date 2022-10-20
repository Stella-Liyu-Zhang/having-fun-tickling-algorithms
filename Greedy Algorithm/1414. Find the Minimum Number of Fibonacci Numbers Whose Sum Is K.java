/*
We greedily subtract the biggest Fibonacci number x from k,
and recursive to find the result for k - x.
Then f(k) = f(k - x) + 1
*/

class Solution {
    public int findMinFibonacciNumbers(int k) {
        if (k < 2)
            return k;
        int a = 1, b = 1;

        // first, get the next fibonacci number that is greater than or equal to k
        while (b <= k) {
            b = b + a; // make b the next fibo number after b
            a = b - a; // make a to be b before incrementing it
        }
        return 1 + findMinFibonacciNumbers(k - a); // need these times plus 1, just for the "a"
    }
}
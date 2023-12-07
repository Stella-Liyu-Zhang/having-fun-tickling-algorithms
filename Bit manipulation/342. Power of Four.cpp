class Solution
{
public:
    /*
    Solution 1:
    1. check if it's a power of 2
    2. check if the rightmost set bit is on an even position.
    4 0100

    0xaaaaaaaa in binary: 10101010101010101010101010101010
    0100 & 1010 = 0000 ok
    return (n > 0) && ((n & (-n)) == n) && ((n & 0xaaaaaaaa) == 0);

    Solution 2: Use math

    */
    bool isPowerOfFour(int n)
    {
        return (n > 0) && ((n & (-n)) == n) && (n % 3 == 1);
    }
};
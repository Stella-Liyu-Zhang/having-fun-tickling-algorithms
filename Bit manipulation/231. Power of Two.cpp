class Solution
{
public:
    /*
    2 -> 00010
    4 -> 00100
    8 -> 01000


    A number that is not a power of two has more than one 1-bit in its binary representation:
    3 -> 0011
    Extract the rightmost set bit, check if it's equal to original

    */
    bool isPowerOfTwo(int n)
    {
        if (n == 0)
        {
            return false;
        }
        long temp = n;
        if ((temp & (-temp)) != n)
        {
            return false;
        }
        return true;
    }
};
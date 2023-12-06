class Solution
{
public:
    /*
    L and R <= 10^6. You can notice that 2^10 = 1024 > 1000 = 10^3, so 2^10 > 10^3.
    Therefore 10^6 = (10^3)^2 < (2^10)^2 = 2^20.
    So the maximum length of number L and R in binary representation is 20.

    Time: O(D), where D = R - L
    Space: O(1)
    */
    int countPrimeSetBits(int left, int right)
    {
        set<int> primes = {2, 3, 5, 7, 11, 13, 17, 19};
        int count = 0;
        for (int i = left; i <= right; i++)
        {
            int bits = 0;
            for (int n = i; n > 0; n >>= 1)
            {
                bits += n & 1;
            }
            count += primes.contains(bits) ? 1 : 0;
        }
        return count;
    }
};
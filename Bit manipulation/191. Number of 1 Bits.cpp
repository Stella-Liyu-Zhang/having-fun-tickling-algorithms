class Solution
{
public:
    int hammingWeight(uint32_t n)
    {
        int res = 0;
        while (n != 0)
        {
            // clears the rightmost set bit in n.
            n = n & (n - 1);
            res++;
        }
        return res;
    }
};

// Solution 2
class Solution
{
public:
    int hammingWeight(uint32_t n)
    {
        uint32_t res = 0;
        ulong mask = 1;
        for (int i = 0; i < 32; i++)
        {
            if ((n & mask) != 0)
            {
                res++;
            }
            mask = mask << 1;
        }
        return res;
    }
};
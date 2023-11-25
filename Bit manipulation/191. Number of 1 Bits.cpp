class Solution
{
public:
    // unsigned integer in cpp is a data type that only represents non-negative integers
    int hammingWeight(uint32_t n)
    {
        int count = 0;
        while (n)
        {
            n &= (n - 1);
            count++;
        }
        return count;
    }
};
class Solution
{
public:
    uint32_t reverseBits(uint32_t n)
    {
        uint32_t ans = 0;
        int pos = 31;
        while (n != 0)
        {
            // n = (n & 1) << pos; -> we don't need to modify the n here!!!! just add it to our ans.
            ans += (n & 1) << pos;
            n = n >> 1;
            pos--;
        }
        return ans;
    }
};
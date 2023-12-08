class Solution
{
public:
    /*
    Solution 1:
    1. extract the rightmost bit of n, by ANDing with 1
    2. move left << by power
    3. power --;
    4. n move right by 1

  Time: O(1)
  Space: O(1)

    Solution 2:
    divide and conquer:


    */
    uint32_t reverseBits(uint32_t n)
    {
        n = (n >> 16) | (n << 16);
        n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
        return n;
    }
};
class Solution
{
public:
    /*
    Since X XOR X = 0, X XOR 0 = X
    bitmask with XOR would only keep the bits that appear odd number of times.
    Since -x = NOT X + 1, (x & (-x)) is a way to isolate the rightmost 1-bit, i.e. to keep the rightmost 1-bit and to set all the other bits to zero.

 When a particular digit is 1, we say it is a "set bit"; when it's 0, we say it's a "clear bit" or "unset bit."

 ~(diff - 1) = - (diff - 1) - 1 = -diff.
    */
    vector<int> singleNumber(vector<int> &nums)
    {
        unsigned int xorRes = 0;
        for (int i : nums)
        {
            xorRes ^= i;
        }
        // the last set bit
        xorRes &= ~(xorRes - 1);
        // divide the array into 2 groups based  on the rightmost set bit
        int a = 0, b = 0;
        for (int n : nums)
        {
            if ((n & xorRes) == 0)
            {
                a = a ^ n;
            }
            else
            {
                b = b ^ n;
            }
        }
        return vector<int>{a, b};
    }
};
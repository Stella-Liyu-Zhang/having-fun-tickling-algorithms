class Solution
{
public:
    /*
    left, right
    AND operation on all the numbers, the remaining part of bit strings is the common prefix of all these bit strings.

    Time: O(1)
    Space: O(1)
    */
    int rangeBitwiseAnd(int left, int right)
    {
        int shift = 0;
        while (left != right)
        {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
};
class Solution
{
public:
    /*

    reduce both numbers into their common prefix, by doing right shift iteratively.

    Time: O(1)
    Space: O(1)
    Constraints:

    5 & 6 & 7
    O(N) -> n = RIGHT-LEFT +1
    [1,10000]

    01 = 1
    10 = 2
    11

    0 & 1 -> 0
    1 & 0 - > 0
    00 & 11 -> 00

    1 & 1 -> 1
    N & M ->
    0111 = 7
    1000 = 8
    1001 = 9
    1010 = 10
    1011 = 11
    0000

    0111 -> 7 -> 0011 -> 0001 -> 0000 -> 0000
    1011 -> 1+2+8=11 -> 0101 -> 0010 -> 0001 -> 0000

    [7,11]
    counter = 4;

    [5,7]
    0101 -> 0010 -> 0001
    0111 -> 0011 -> 0001
    0100 -> 4
    counter = 2
    0100

    O(LEFT-1)
    log_2(left) - 1
    O(1) -> 64 bit in total at most, constriain
    64 bit architecture

    */

    int rangeBitwiseAnd(int left, int right)
    {
        int shift = 0;
        while (left != right)
        {
            shift++;
            left >>= 1;
            right >>= 1;
        }
        return left << shift;
    }
};
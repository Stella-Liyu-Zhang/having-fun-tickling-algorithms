/*
Iterative solution:

The 1-bit Gray code is 0, 1; * The 2-bit Gray code is 0, 1, 3, 2, and the corresponding binary representation is 00, 01, 11, 10.
G(N): gray code sequence consisting of numbers between 0 to 2^{n-1}.
Iteratively find G(N-1) first.
Then add the prefix 0 to each digit of G(N-1).
Reverse G(N-1) and add the prefix 1 to each digit of the reversed G(N-1) sequence,
combine the above 2 sequences.
n = 2
00
01
11
10

n = 3
000
001
011
010

110
111
101
100

i = 1
[0]
bitmask: 1
[0, 1]

i = 2
bitmask: 1 << (2-1) = 2
[0, 1, 2, 3]

i = 3
bitmask 1 << (3-1) = 4
[0,1,2,3,4,5,6,7]


int mask = 1 << (i - 1); is creating a bitmask.
, the line int mask = 1 << (i - 1); creates a bitmask with the i-th bit set to 1 and all other bits set to 0.
When i is 1, 1 << (i - 1) is equivalent to 1 << 0, which is 000...0001 in binary (unchanged).
When i is 2, 1 << (i - 1) is equivalent to 1 << 1, which is 000...0010 in binary (shifted one position to the left).
When i is 3, 1 << (i - 1) is equivalent to 1 << 2, which is 000...0100 in binary (shifted two positions to the left).
*/
class Solution
{
public:
    vector<int> grayCode(int n)
    {
        vector<int> res;
        res.push_back(0);

        for (int i = 1; i <= n; i++)
        {
            int prevSize = res.size();
            int bitmask = 1 << (i - 1);
            for (int j = prevSize - 1; j >= 0; j--)
            {
                res.push_back(bitmask + res[j]);
            }
        }
        return res;
    }
};
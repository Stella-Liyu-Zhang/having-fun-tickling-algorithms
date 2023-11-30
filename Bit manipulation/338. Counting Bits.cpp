class Solution
{
public:
    /*
    res[i] = res[i/2] + i % 2;
    res[i] = res[i >> 1] + (i & 1);
    This change ensures that the bitwise AND operation (i & 1) is evaluated before the addition.
    ans[i >> 1]: Retrieves the count of set bits for the number obtained by right-shifting i by 1.
    (i & 1): Adds 1 to the count if the least significant bit of i is set.
The result is the count of set bits for the binary representation of i.


    */
    vector<int> countBits(int n)
    {
        vector<int> res(n + 1, 0);
        for (int i = 1; i <= n; i++)
        {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
};
class Solution
{
public:
    /*
    n ^ n -> 0
    n ^ 0 -> n
    -> remainder

    */
    int singleNumber(vector<int> &nums)
    {
        int res = 0;
        for (int n : nums)
        {
            res = res ^ n;
        }
        return res;
    }
};
class Solution
{
public:
    vector<int> getConcatenation(vector<int> &nums)
    {
        int n = nums.size();
        vector<int> res(n * 2);

        if (n == 0)
        {
            return res;
        }
        memcpy(res.data(), nums.data(), n * sizeof(int));
        memcpy(res.data() + n, nums.data(), n * sizeof(int));
        return res;
    }
};
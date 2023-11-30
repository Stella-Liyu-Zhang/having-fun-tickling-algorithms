class Solution
{
public:
    int singleNumber(vector<int> &nums)
    {
        unordered_map<int, int> map;
        for (auto i : nums)
        {
            map[i]++;
        }
        for (auto j : map)
        {
            if (j.second == 1)
            {
                return j.first;
            }
        }
        return -1;
    }
};
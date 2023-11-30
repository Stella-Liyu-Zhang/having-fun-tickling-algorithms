class Solution
{
public:
    /*
    2 -> once
    other -> twice

    HashMap:
    key: int
    value: int

    */
    vector<int> singleNumber(vector<int> &nums)
    {
        vector<int> res;
        unordered_map<int, int> map;
        for (auto n : nums)
        {
            map[n]++;
        }
        for (auto j : map)
        {
            if (j.second == 1)
            {
                res.push_back(j.first);
            }
        }
        return res;
    }
};
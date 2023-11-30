class Solution
{
public:
    /*
    -> set^val
    1. adding "val" to the "set" if "val" is not in the "set" => A^0 = A
    2. removing "val" from the "set" if "val" is already in the "set" => A^A = 0

    "(ones ^ A[i]) & ~twos" basically means perform the above mentioned operation if and only if A[i] is not present in the set "twos". So to write it in layman:
   IF the set "ones" does not have A[i]
       Add A[i] to the set "ones" if and only if its not there in set "twos"
   ELSE
       Remove it from the set "ones"

    After this, we immediately update set "twos" as well with similar logic:
"(twos^ A[i]) & ~ones" basically means:

   IF the set "twos" does not have A[i]
       Add A[i] to the set "twos" if and only if its not there in set "ones"
   ELSE
       Remove it from the set "twos"

    This approach works by using XOR to handle the appearance of each bit in multiples of three. When a bit appears for the first time, it's stored in ones, and when it appears for the second time, it's moved to twos. If it appears for the third time, both ones and twos will cancel out that bit. In the end, only the bits of the element appearing once will be present in ones.
    */
    int singleNumber(vector<int> &nums)
    {
        int ones = 0;
        int twos = 0;
        for (int i : nums)
        {
            ones = (ones ^ i) & ~twos;
            twos = (twos ^ i) & ~ones;
        }
        return ones;
    }
};
class Solution
{
public:
    /*
    3 -> 0011
    9 -> 1+8 01001
    27 -> 1+16+2+8 ->     11011

    1. Solution 1
      while(n % 3 == 3){
          n = n / 3;
      }
      return n == 1;
      O(log_3(n))
      O(1)

    2. Solution 2
      O(1)
       return n > 0 && 1162261467 % n == 0;

    */
    bool isPowerOfThree(int n)
    {
        if (n < 1)
        {
            return false;
        }
        while (n % 3 == 0)
        {
            n = n / 3;
        }
        return n == 1;
    }
};
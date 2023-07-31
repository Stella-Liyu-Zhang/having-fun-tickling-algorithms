public class Solution {
    // you need to treat n as an unsigned value
    /*
     * An Integer in Java has 32 bits, e.g. 00101000011110010100001000011010.
        To count the 1s in the Integer representation we put the input int
        n in bit AND with 1 (that is represented as
        00000000000000000000000000000001, and if this operation result is 1,
        that means that the last bit of the input integer is 1. Thus we add it to the 1s count.
     * Then we shift the input Integer by one on the right, to check for the next bit.
     * We keep doing this until the input Integer is 0.
     * 
     */
    public int hammingWeight(int n) {
        int ones = 0;
        for(int i = 0; i < 32; i ++){
            ones = ones + (n&1);
            n = n >>> 1;
        }
        return ones;
    }
}

public class Solution2 {
    // you need to treat n as an unsigned value
    // The run time depends on the number of 111-bits in nnn. In the worst case, all bits in nnn are 111-bits. In case of a 32-bit integer, the run time is O(1)O(1)O(1).
    // The space complexity is O(1)O(1)O(1), since no additional space is allocated.
    /*
    the Brian Kernighan's algorithm for counting set bits.

    The term "least-significant 1-bit" refers to the rightmost (lowest-order) 1-bit in the binary representation of a number. 
    
    When you subtract 1 from a binary number, it will have the effect of changing the rightmost 1-bit to 0 and all the bits to the right of it to 1.

    */
    public int hammingWeight(int n) {
        int ones = 0;
        while (n!= 0){
            ones ++;
            n = n & (n-1);
        }
        return ones;
    }
}
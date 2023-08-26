class Solution {
    /*
    Key takeways:
    to check vowel, don't need a helper function, just need to build a hashset.
    Set.of() method to set the elements if they are fixed.

    method:
    always get the initial k (sliding window length) elements' result, and store them in an integer called count.
    And we will be having an index of right boundary by sliding to the right every time.

    and the key to sliding window algo is to 
    get rid of i-k, and add the i element to it each time we move right by 1. 

    and always using a max variable to update the max. 
    */
    public int maxVowels(String s, int k) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for(int i = 0; i < k; i ++){
            if (set.contains(s.charAt(i))){
                count ++;
            }
        }
        int i = 0; //index of its right boundary
        int res = count;
        for(i = k; i < s.length(); i ++){
            if(set.contains(s.charAt(i))){
                count ++;
            }
            if(set.contains(s.charAt(i-k))){
                count --;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
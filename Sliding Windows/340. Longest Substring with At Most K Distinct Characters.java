class Solution {
    /*
    input: string s, integer k
    substring of s at most k distinct characters
    longest

    K is fixed
    slow = 0
    fast = 0
    int numOfdistinctChars = 1+1;
    HashSet<>() 
    eceba

    if(numOfdistinctChars> k){
        if(!set contains s.charAt(slow)){
            numOfdistinctChars --;
        }
        slow ++
    }
    fast ++
    return fast - slow

    */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int slow = 0, fast = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(fast < s.length()){
            map.put(s.charAt(fast), map.getOrDefault(s.charAt(fast), 0) + 1);

            while(map.size() > k){
                map.put(s.charAt(slow), map.get(s.charAt(slow)) - 1);

                if(map.get(s.charAt(slow)) == 0){ //slow is distinct
                    map.remove(s.charAt(slow));
                }
                slow ++;
            }
            max = Math.max(max, fast - slow + 1);
            fast ++;
        }
        return max;
    }
}
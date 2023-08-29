class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int slow = 0, fast = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        while(fast < s.length()){
            map.put(s.charAt(fast), map.getOrDefault(s.charAt(fast), 0) + 1);

            while(map.size() > 2){
                map.put(s.charAt(slow), map.get(s.charAt(slow)) - 1);

                if(map.get(s.charAt(slow)) == 0){ //slow is distinct
                    map.remove(s.charAt(slow));
                }
                slow ++;
            }
            fast ++;

            max = Math.max(max, fast-slow);
        }
        return max;
    }
}
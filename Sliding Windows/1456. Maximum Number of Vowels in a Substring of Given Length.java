class Solution {
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
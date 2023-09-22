class Solution {
    /*
    HashMap
    key: char at s 
    value: char at t
    loop through, 
    if containskey, check if match
    else if not containskey, 
    before add it, we check if the value is contained.
    because if it doesn't contain key, but contains value, it's also a mismatch
    */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap();
        if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); i ++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(map.containsKey(sChar)){
                if(map.get(sChar) != tChar){
                    return false;
                }
            }else{
                if(map.containsValue(tChar)){
                    return false;
                }
                map.put(sChar, tChar);
            }
        }
        return true;
    }
}
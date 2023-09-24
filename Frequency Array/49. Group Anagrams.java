class Solution {
    /*
    HashMap
    Key: charFrequency string that represents the freq
    Value: List<String>, that matches the charFreq
    loop through strs,
    generate a new charFreq string each time
        if the map contains the charFreq, we just append the string into the list of values
        If the map does not contain the charFreq, we make a new arraylist and add the current string into it
    Return the List of values() of hashmap
    
    Complexity: 
    iif N is the lenght of strs and K is the maximum length fo a string,
    Time: O(NK)
    Space: O(NK), the total info content stored in ans
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for(String s: strs){
            char[] charFreq = new char[26];
            for(char c: s.toCharArray()){
                charFreq[c-'a'] ++;
            }
            String curr = new String(charFreq);
            List<String> temp= map.getOrDefault(curr, new ArrayList());
            temp.add(s);
            map.put(curr, temp);
        }
        List<List<String>> ans = new ArrayList();
        for(List<String> list: map.values()){
            ans.add(list);
        }
        return ans;
    }
}
class Solution {
    /*
    1) occurence table int[] arr = new int[26];
    2) az --> 100000000001
    3) key: 111 -string
       value: "eat" "tae".... 
    4) looping through the map, check keys are the same, group the values
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for(String str: strs){
            char[] occur = new char[26];
            for(char c: str.toCharArray()){
                occur[c-'a'] ++;
            }
            String store = new String(occur);
            List<String> tempList = map.getOrDefault(store, new ArrayList<>());
            tempList.add(str);
            map.put(store, tempList);
        }
        List<List<String>> res = new ArrayList();
        for(List<String> temp: map.values()){
            res.add(temp);
        }
        return res;
    }
}
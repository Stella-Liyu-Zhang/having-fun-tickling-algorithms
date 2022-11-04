class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList();
        if (strs.length == 0)
            return list;
        // key: sorted string
        // value: the list of anagram strings
        HashMap<String, List<String>> map = new HashMap();
        for (String curr : strs) {
            char[] c = curr.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList());
            }
            // add the current word to the arraylist
            map.get(sorted).add(curr);
        }
        list.addAll(map.values());
        return list;
    }
}
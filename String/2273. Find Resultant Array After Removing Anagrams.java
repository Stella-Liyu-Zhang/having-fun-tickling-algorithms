class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        String prev = "";
        for (int i = 0; i < words.length; i++) {
            char[] ch = words[i].toCharArray();
            Arrays.sort(ch);
            String curr = new String(ch);
            if (!curr.equals(prev)) {
                list.add(words[i]);
                prev = curr;
            }
        }
        return list;
    }
}
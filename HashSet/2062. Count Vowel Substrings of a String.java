class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        HashSet<Character> set = new HashSet();
        for(int i = 0; i < word.length() - 4; i ++){
            set.clear();
            for(int j = i; j < word.length(); j++){
                char c = word.charAt(j);
                if(c == 'a' || c =='e' || c=='i' || c =='o' || c == 'u' ){
                    set.add(c);
                    if(set.size() == 5){
                        count ++;
                    }
                }else{
                    break;
                }
            }
        }
        return count;
        
    }
}
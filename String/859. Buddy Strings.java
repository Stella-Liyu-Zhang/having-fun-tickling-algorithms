class Solution {
    /*
    Make sure the strings have to be the same size check
    
    use a list to store the indexes of chars that are different
    and the size of the list needs to be 2 in order to be able to perform the swap.


    */
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }

        if(s.equals(goal)){     
            // If we have 2 same characters in string 's',
            // we can swap them and still the strings will remain equal.

            int[] freq = new int[26];
            for(char c: s.toCharArray()){
                freq[c-'a'] ++;
                if(freq[c-'a'] == 2){
                    return true;
                }
            }
            return false;
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) != goal.charAt(i)){
                list.add(i);
            }
        }
        if(list.size() == 2 
        && s.charAt(list.get(0)) == goal.charAt(list.get(1))
        && s.charAt(list.get(1)) == goal.charAt(list.get(0)) ){
            return true;
        }else{
            return false;
        }
    }
}

//second attempt
class Solution {
    /*
    3 scenarios:
    1. s and goal have diff length
    2. the two strings are equal, so we swap the same nummber
    3. the 2 strings have 2 diffs, and they are the same diction of 2 letters


    */
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        if(s.equals(goal)){
            Set<Character> set = new HashSet<>();
            for(char c: s.toCharArray()){
                set.add(c);
            }
            return set.size() < s.length();
        }
        List<Integer> diff = new ArrayList<>();
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) != goal.charAt(i)){
                diff.add(i);
            }
        }
        return (diff.size() == 2 
                && s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) 
                && s.charAt(diff.get(1)) == goal.charAt(diff.get(0)));
    }
}
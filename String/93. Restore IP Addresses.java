
/*
3-loop divides the string s into 4 substring: s1, s2, s3, s4. Check if each substring is valid.
In isValid, strings whose length greater than 3 or equals to 0 is not valid; or if the string's length is longer than 1 and the first letter is '0' then it's invalid; or the string whose integer representation greater than 255 is invalid.*/

//I regard this way as another interpretation of recursive DFS, but doing all the operations using loops. 
//We are finding 4 points to segment the given string, so the number of total operation in the loops should be 3^4. 
//In each operation, we use String#substring and String concatenation, which in Java 8 String#substring is O(n) 
//and concatenation is O(length of str1 + length of str2). I assume that in each operation we need 4 concatenation, and each substring has a length 3, which takes O(n) + O(4 * 3 ^ 2) which is O(n) still. So the total time complexity of this algorithm is O(n * 3^4) = O(81n) = O(n)

class Solution {
    public List<String> restoreIpAddresses(String s) {
        // Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
        List<String> ans = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++) { // 3
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) { // 3
                for (int k = j + 1; k < j + 4 && k < len; k++) { // 3
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);

                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        ans.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return ans;

    }

    boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1 || Integer.parseInt(s) > 255))
            return false;
        return true;
    }
}
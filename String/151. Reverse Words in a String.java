class Solution {
    public String reverseWords(String s) {
        //+ is a regex, split on one or more space
        //"\s" is a regex class for any kind of whitespace (space, tab, newline, etc). Since Java uses "\" as an escape character in strings (e.g. for newlines: "\n"), we need to escape the escape character ;-) So it becomes "\\s". The "+" means one or more of them.
        //trim removes leading space
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
/* 
Explanation:

First, we have a loop that traverses the word list and for each item, we sort the item.
After that, we have another for loop that traverses the string and checks if the item exists inside the string.
If the item exists inside the string then the index variable count will reach the length of the string.
we check if index variable i is equal to the length of the string then return the current list item.
If it is not equal then we check for the next item in the words list.
In the end, if none of the items is present inside the string then we return "-".
*/

import java.io.*;
import java.util.*;

public class Main {

    public static String find(String[] words, String key) {
        char[] keychars = key.toCharArray();
        Arrays.sort(keychars);
        String sortedkey = new String(keychars); // sort the key

        for (int i = 0; i < words.length; i++) {
            // sort word[i] and store in sortedword
            char[] wordschar = words[i].toCharArray();
            Arrays.sort(wordschar);
            String sortedword = new String(wordschar); // sort the key
            System.out.println(sortedword);
            int count = 0;
            for (Character c : sortedkey.toCharArray()) {
                // checking if i is less than the length of the list item
                // and character is equal to myItem character
                if (count < sortedword.length() && c == sortedword.charAt(count)) {
                    count++;
                }
            }

            if (count == words[i].length())
                return words[i];
        }

        return "-";
    }

    public static void main(String[] args) {
        String[] words = { "baby", "referee", "cat", "dada", "dog", "bird", "ax" };
        String string1 = "ctay";
        String string2 = "bcanihjsrrrferet";
        String string3 = "tbaykkjlga";
        String string4 = "bbbblkkjbaby";
        String string5 = "dad";
        String string6 = "breadmaking";
        System.out.println(find(words, string1));
        System.out.println(find(words, string2));
        System.out.println(find(words, string3));
        System.out.println(find(words, string4));

    }
}

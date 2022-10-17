Similarly, an API lists a bunch of operations that developers can use, along with a description of what they do. The developer doesn’t necessarily need to know how, for example, an operating system builds and presents a “Save As” dialog box. They just need to know that it’s available for use in their app.
/\*
You are running a classroom and suspect that some of your students are passing around the answer to a multiple-choice question disguised as a random string.

Your task is to write a function that, given a list of words and a string, finds and returns the word in the list that is scrambled inside the string, if any exists. If none exist, it returns the result "-" as a string. There will be at most one matching word. The letters don't need to be in order or next to each other. The letters cannot be reused.

Example:  
words = ["baby", "referee", "cat", "dada", "dog", "bird", "ax"]
string1 = "ctay"

[b, a, b, y]

{
'c': 0
't': 1
'a': 0
'y': 0
}

find(words, string1) => "cat" (the letters do not have to be in order)

string2 = "bcanihjsrrrferet"
find(words, string2) => "cat" (the letters do not have to be together)

string3 = "tbaykkjlga"
find(words, string3) => "-" (the letters cannot be reused)

string4 = "bbbblkkjbaby"
find(words, string4) => "baby"

{
'b': 4,
'l': 1,
...
}

string5 = "dad"
find(words, string5) => "-"

string6 = "breadmaking"
find(words, string6) => "bird"

All Test Cases:
find(words, string1) -> "cat"
find(words, string2) -> "cat"
find(words, string3) -> "-"
find(words, string4) -> "baby"
find(words, string5) -> "-"
find(words, string6) -> "bird"

Complexity analysis variables:

W = number of words in `words`  
S = maximal length of each word or string  
\*/

import java.io._;
import java.util._;
/\*
words = ["baby", "referee", "cat", "dada", "dog", "bird", "ax"]
string1 = "ctay"

find(words, string1) => "cat" (the letters do not have to be in order)

string2 = "bcanihjsrrrferet"
find(words, string2) => "cat" (the letters do not have to be together)

[c, a ,t ]

{
'c': -1
't': 0
'a': 0
'y': 1
}

find(words,

\*/
public class Solution {

public static String find (String[] words, String key){
HashMap<Character, Integer> hm = new HashMap<>();

    for (Character c: key.toCharArray()){
      if (!hm.containsKey(c)) hm.put(c,1);
      else{
        int value = hm.get(c);
        value ++;
        hm.put(c,value);
      }
    }

    for(int i = 0; i < words.length; i ++){
      for(Character c: words[i].toCharArray()){
        if (hm.containsKey(c)){ //decrement
           int value = hm.get(c);
           value --;
           hm.put(c,value);
        }
      }
    }
    Boolean temp = true;
    String ans = "";
        for(int i = 0; i < words.length; i ++){
          for(Character c: words[i].toCharArray()){
            if (!hm.containsKey(c) || hm.get(c) < 0){
               temp = false;
            }
          }
          if (temp == true) ans = words[i];
        }

        if (temp == false){
          return "-";
        }else{
          return ans;
        }

}

public static void main(String[] argv) {
String[] words = {"baby", "referee", "cat", "dada", "dog", "bird", "ax"};
String string1 = "ctay";
String string2 = "bcanihjsrrrferet";
String string3 = "tbaykkjlga";
String string4 = "bbbblkkjbaby";
String string5 = "dad";
String string6 = "breadmaking";
System.out.println(find(words, string1));
}
}

问题：

[NEED IT IN PYTHON]

Q1.You are running a classroom and suspect that some of your students are passing around the answer to a multiple-choice question disguised as a random string.

Your task is to write a function that, given a list of words and a string, finds and returns the word in the list that is scrambled inside the string, if any exists. If none exist, it returns the result "-" as a string. There will be at most one matching word. The letters don't need to be in order or next to each other. The letters cannot be reused.

Example:  
words = ["baby", "referee", "cat", "dada", "dog", "bird", "ax"]
string1 = "ctay"
find(words, string1) => "cat" (the letters do not have to be in order)

string2 = "bcanihjsrrrferet"
find(words, string2) => "cat" (the letters do not have to be together)

string3 = "tbaykkjlga"
find(words, string3) => "-" (the letters cannot be reused)

string4 = "bbbblkkjbaby"
find(words, string4) => "baby"

string5 = "dad"
find(words, string5) => "-"

string6 = "breadmaking"
find(words, string6) => "bird"

All Test Cases: <br>
find(words, string1) -> "cat" <br>
find(words, string2) -> "cat" <br>
find(words, string3) -> "-" <br>
find(words, string4) -> "baby" <br>
find(words, string5) -> "-" <br>
find(words, string6) -> "bird" <br>

Complexity analysis variables:

W = number of words in `words`  
S = maximal length of each word or string

q2.

After catching your classroom students cheating before, you realize your students are
getting craftier and hiding words in 2D grids of letters. The word may start anywhere in the grid,
and consecutive letters can be either immediately below or immediately to the right of the previous letter.
Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates.
If there are multiple matches, return any one.

grid1 = [
['c', 'c', 't', 'n', 'a', 'x'],  
 ['c', 'c', 'a', 't', 'n', 't'],  
 ['a', 'c', 'n', 'n', 't', 't'],  
 ['t', 'n', 'i', 'i', 'p', 'p'],  
 ['a', 'o', 'o', 'o', 'a', 'a'],
['s', 'a', 'a', 'a', 'o', 'o'],
['k', 'a', 'i', 'o', 'k', 'i'],
]
word1 = "catnip"
word2 = "cccc"
word3 = "s"
word4 = "ant"
word5 = "aoi"
word6 = "ki"
word7 = "aaoo"
word8 = "ooo"

grid2 = [['a']]
word9 = "a"

find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
find_word_location(grid1, word2) =>
[(0, 0), (1, 0), (1, 1), (2, 1)]
OR [(0, 0), (0, 1), (1, 1), (2, 1)]
find_word_location(grid1, word3) => [(5, 0)]
find_word_location(grid1, word4) => [(0, 4), (1, 4), (2, 4)] OR [(0, 4), (1, 4), (1, 5)]
find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
find_word_location(grid1, word6) => [(6, 4), (6, 5)]
find_word_location(grid1, word7) => [(5, 2), (5, 3), (5, 4), (5, 5)]
find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
find_word_location(grid2, word9) => [(0, 0)]

Complexity analysis variables:

r = number of rows
c = number of columns
w = length of the word

答案：

Below is the python program for the above two questions, comments are also added to the program for better understanding.

Q1.)

# Here is the find() function which finds the word string

def find(words, string1): # sorting the string
myString = ''.join(sorted(string1))

    # traversing in the words list
    for item in words:
        # sort the list item
        myItem = ''.join(sorted(item))
        # i variable for indexing in the list item
        i = 0
        # traversing each character in the myString
        for char in myString:
            # checking if i is less than the length of the list item and character is equal to myItem character
            if i < len(myItem) and char == myItem[i]:
                # incrementing the index variable
                i += 1
        # checking if i is equal to item length
        if i == len(item):
            # return the item
            return item
    # return hyphen if the item is not found
    return "-"

# Creating a word list

words = ["baby", "referee", "cat", "dada", "dog", "bird", "ax"]

# creating a string

string1 = "ctay"
string2 = "bcanihjsrrrferet"
string3 = "tbaykkjlga"
string4 = "bbbblkkjbaby"
string5 = "dad"
string6 = "breadmaking"

# calling find() function

print(find(words, string1)) # -> "cat" <br>
print(find(words, string2)) # -> "cat" <br>
print(find(words, string3)) # -> "-" <br>
print(find(words, string4)) # -> "baby" <br>
print(find(words, string5)) # -> "-" <br>
print(find(words, string6)) # -> "bird" <br>
Output Screenshot:

cat
cat
baby
bird

Explanation:

First, we have a loop that traverses the word list and for each item, we sort the item.
After that, we have another for loop that traverses the string and checks if the item exists inside the string.
If the item exists inside the string then the index variable i will reach the length of the string.
we check if index variable i is equal to the length of the string then return the current list item.
If it is not equal then we check for the next item in the words list.
In the end, if none of the items is present inside the string then we return "-".

Q2.)

# Here is the find_word_location() function

def find_word_location(grid1, word1): # k variable for indexing in the word string
k = 0 # row list stores the row indexes
rowList = [] # column list stores the column indexes
colList = []

    # traversing in the grid
    for i in range(len(grid1)):
        for j in range(len(grid1[i])):
            # checking if k is less than the length of word string and grid character is equal to word character
            if k < len(word1) and grid1[i][j] == word1[k]:
                # incrementing index
                k += 1;
                # appending row
                rowList.append(i)
                # appending column
                colList.append(j)

        # checking if k reaches a length of the word then break
        if k == len(word1):
            break

    # merging the two lists in a tuple of list
    mergedList = [(rowList[i], colList[i])
    for i in range(0, len(rowList))]

    # return the merged list
    return mergedList

# creating a grid

grid1 = [
['c', 'c', 't', 'n', 'a', 'x'],
['c', 'c', 'a', 't', 'n', 't'],
['a', 'c', 'n', 'n', 't', 't'],
['t', 'n', 'i', 'i', 'p', 'p'],
['a', 'o', 'o', 'o', 'a', 'a'],
['s', 'a', 'a', 'a', 'o', 'o'],
['k', 'a', 'i', 'o', 'k', 'i'],
]

# creating a word string

word1 = "catnip"
word2 = "cccc"

grid2 = [['a']]
word9 = "a"

# calling the function find_word_location()

print("Coordinates: ",find_word_location(grid1, word1))
print("Coordinates: ",find_word_location(grid1, word2))
print("Coordinates: ",find_word_location(grid2, word9))
Output Screenshot:

Coordinates:
Coordinates:
Coordinates:
[(0, 0), (0, 4), (1, 3), (1, 4), (3, 2), (3, 4)]
[(0, 0), (0, 1), (1, 0), (1, 1)]
[(0,

Explanation:

We start traversing the grid and check if the character in the grid is equal to the character of the word string.
If the characters are equal, we increment the index variable k and append the row and column into the list.
Every time the inner loop completes we check if the index variable k is equal to word length, if it is equal then we terminate the loop.
In the end, we convert the row list and column list into a list of tuples and return the final list.

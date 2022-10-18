## API

Similarly, an API lists a bunch of operations that developers can use, along with a description of what they do. The developer doesn’t necessarily need to know how, for example, an operating system builds and presents a “Save As” dialog box. They just need to know that it’s available for use in their app.

## h

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

Q2.)

# Here is the find_word_location() function

```py
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
```

Explanation:

We start traversing the grid and check if the character in the grid is equal to the character of the word string.
If the characters are equal, we increment the index variable k and append the row and column into the list.
Every time the inner loop completes we check if the index variable k is equal to word length, if it is equal then we terminate the loop.
In the end, we convert the row list and column list into a list of tuples and return the final list.

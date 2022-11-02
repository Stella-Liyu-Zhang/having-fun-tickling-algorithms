# Backtracking

## basic psuedocode

```
Pick a starting point.
while(Problem is not solved)
    For each path from the starting point.
        check if selected path is safe, if yes select it
        and make recursive call to rest of the problem
        before which undo the current move.
    End For
If none of the move works out, return false, NO SOLUTON.

```

## (PermuationI, Permuation II)

- As I think for permutation at least, it is O(n!), since you have 10 numbers, you choose one of the ten number from it, then you choose one of nine numbers from it and then ......, Thus it is 109876...\*1
- For Space complexity, I regard stack usage is O(n), since we go depth to n (10 -> 9->8->7-> .....-> 1), for heap usage, we have variable, which store the current variable with size n. In a nutshell, it should be n
  PermuationII in worst case, all number not duplication -> same as I

## (SubsetI and SubsetII)

- Time complexity is O(2 ^ n), since we have 2 ^ n possibilities about the element, for every element we can choose or not choose, thus it is 2 ^ n
- Space complexity, same as Permutation, O(n)

## (Combination SumI and II)

Lets put this example [1,2,3,4,5,6,7,8,9,10] -> target: 300, we find out, it is not possible to go to 300, thus we either choose a element or not, it is the same time complexity as subset, which comes to O(2^n)

- Space complexity, same as O(n)

## (Palindrome Partition)

Difficult to think, let take an example "aaaaa", 1 represents we choose it, 0 represents we open a new string [11101] -> ["aaa", "aa"], [11011] -> ["aa", "aaa"], [11110] -> ["aaaa", "a"], thus, you see we have O(2 ^ n), and every time we decide whether it is palindrome, it is O(n) , so it is O(2 ^ n \* n)

- Space complexity, O(n), same as other questions
- Palindrome partitioning will be O(2^(n-1)). For a string of length n, there will be (n-1) partitions.
  For e.g, string is "abc"
  it has 2 partitions: a|b|c

if we use both first and second partition => [a,b,c]
if we use only first => [a, bc]
if we use only second => [ab,c]
if we use nonw => [abc]
Thus, we either select or ignore from among (n-1) partitions.
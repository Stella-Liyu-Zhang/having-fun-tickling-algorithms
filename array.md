# Array

An array is basic data structure to store a collection of element sequentially. But elements can be accessed randomly since each element in the array can be identified with an array index, for example, array[0], array[101], etc.
An array can have one or more dimensions.
One-dimensional array:

## linear array:

A[0] = 6. Similarly, A[1] = 3, A[2] = 8 and so on.

## Operations in Array:

### Initialize an array:

    Int[] a0 = {1,2,3}
    Int[] a1 = new int[5];  //an empty array

### Get the length:

a1.length

### Access Element:

```java
a1[0]
```

### Iterate through all elements:

```java
For (int i = 0; i < a1.length; i++){
    System.out.println(“ “ + a1[i]);
}
```

### Modify Element:

```java
a1[0] = 5
```

### Sort:

```java
Arrays.sort(a1);
```

An array has a fixed capacity, 我们必须 specify the size of the array when we initialize the array.
Therefore, we could use built in 的 dynamic array，是一个 random access list data structure, but with variable size.
For example, we have

## ArrayList in Java.

### Initialize an arraylist:

```java
List<Integer> v0 = new ArrayList<>();
List<Integer> v1; // v1 == null
cast an array to a vector
int[] a = {0,1,2,3,};
V1 = new ArrayList<> (Arrays.asList(a));
```

### Make a copy:

```java
LIst<Integer> v2 = v1;   	//Another reference to v1.
List<Integer> v3 = new ArrayList<> v1);     //make an actual copy of v1.
Get length:
v1.size();
```

### Access element:

```java
v1.get(0);
Iterate the vector
for(int i = 0; i < v1.size(); i++){
			v1.get(i)
}
```

### Modify the element:

```java
public E set(int index, E element)
v2.set(0,5); //modify v2 will actually modify v1;
System.out.println (“The first element in v1 is” + v1.get(0)); // get 5
v3.set(0,-1);
System.out. println (“The first element in v1 is” + v1.get(0)); //get -1
```

### Sort

```java
Collections.sort(v1);
```

### Add new element at the end of the vector

```java
public void add(int index, E element)
v1.add(-1);
v1.add(1,6);
```

### Delete the last element

```java
v1.remove(v1.size()-1);
 // use add() method to add elements in the list
      arrlist.add(15);
      arrlist.add(22);
      arrlist.add(30);
      arrlist.add(40);

// adding element 25 at third position
      arrlist.add(2,25);
-----> 15, 22, 25, 30, 40
```

## 1. Find Pivot Index

When I see this problem, the first attempt came up in my mind is to use 2 for loops, and for each index, to check its left and right sum to see if they are equal.
For this attempt, what I will do is to first precompute prefix sums

P[i] = nums[0] + nums[1] + ... + nums[i-1].

Then for each index, the left sum is P[i], and the right sum is P[P.length - 1] - P[i] - nums[i].

And the time complexity would be O(n^2).

However, we don’t need to do this.

- We could first define a totalsum of all the nums[i] recorded, using one linear for-loop.
- Then for each index i, we could use one single for loop through the whole array,
- Consider the edge case when i = 0. Then the leftsum must be 0.
- Consider the rest of cases when i != 0. Then we compute the leftsum of the index.
- Afterwards, we check if (totalsum - leftsum - nums[i] == leftsum), which is to see if the rightsum equals leftsum while excluding the prefix itself.
- If there appears to be the leftest prefix, the first one we came across, we return it.
  Otherwise, return -1.

And the time complexity would be O(n).

## 2. Largest Number At Least Twice of Others

When I first see this problem, my thought is to

- Find the largest element in the array by looping through the array with O(n)
- Loop through the array again to check if each element satisfies the criterion of (nums[larg_index] < nums[i] \* 2)).

However, such method will exeed the time limit.
Ok then ultimately after fixing various problems,
The process remains to be the second condition fixed:
Find the largest element in the array by looping through the array with O(n)
Loop through the array again to check if each element satisfies the criterion of

```java
(nums[larg_index] < nums[i] * 2)) && (i != larg_index).
```

## 3. Plus One

Original thoughts and solution:  
nth: b*10^0,(digits.length-1)th: b*10, (n-2)th: b*10^2 ...., first: b*10^(n-1)

New approach:

- Loop through the array, to see if the last digit is 9.
  - If not, we just need to add 1 to it and return the whole array.
- - If the last digit is 9, we just need to make it 0. And as we loop to the n-1 digit, it will automatically add 1 to it, and return the array itself
- The third case is that if it’s 999, in which case we need to increment the array size by 1, and then make the first digit 1. (eg. 10000).

# Introduction to 2D Array

- Int[][] a – the 2D array itself
- A[i] the one-dimensional array of the ith row
- A[i][j] — the single element

1. In Java, the two-dimensional array is actually a one-dimensional array which contains M elements, each of which is an array of N integers.

## 1. Diagonal Traverse

Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

```java
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null) {
            throw new IllegalArgumentException("Input matrix is null");
        }
        if(mat.length ==0|| mat[0].length == 0){
            return new int[0];
        }
        //First, make an empty array of mat's size:
        int m = mat.length; // rows
        int n = mat[0].length; //col
        int[] arr = new int [m*n];

        int row = 0, col = 0;

        for(int i = 0; i < arr.length; i++){
            arr[i] = mat[row][col];
            if((row+col)%2 == 0){ //move up
                if(col == n-1){// reach the right wall
                    // Reached last column. Now move to below cell in the same column.
                    // This condition needs to be checked first due to top right corner cell.
                    row ++;
                }else if(row == 0){  //reach the top
                    // Reached first row. Now move to next cell in the same row.
                    col ++;
                }else{
                    // Somewhere in middle. Keep going up diagonally.
                    row --;
                    col ++;
                }
            }else{ // move down
                if(row == m - 1){
                    // Reached last row. Now move to next cell in same row.
                    // This condition needs to be checked first due to bottom left corner cell.
                    col ++;
                }else if(col == 0){//reach the bottom
                    // Reached first columns. Now move to below cell in the same column.
                    row ++;
                }else{
                    // Somewhere in middle. Keep going down diagonally.
                    row ++;
                    col --;
                }
            }
        }
        return arr;

    }
}
```

## 54. Spiral Matrix

- How to solve:
  First, since the output is an arraylist, we make the arraylist by

```java
        List <Integer> arr = new ArrayList<>();
```

And usually when we solve this type of problems, what we need to do is to check the edge cases (i.e. in this case, the matrix is either empty or just an array):

```java
        if(matrix.length == 0 || matrix[0].length == 0) return arr;
```

> Afterwards, the algorithm could mainly be described as:
>
> - first, when we move from left to right ( 0 --> matrix[0].length-1) of the top row, add each element, and make the top row move to the second top row.

```java
 for(int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if(left > right || top > bottom) break;
```

> - Next, when we check from top to the bottom of the most right column, and make the rightest column move to the second right column.

```java
   for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if(left > right || top > bottom) break;
```

> - Next, when we check from right to left of the most bottom row, and make the bottomest row move to the next bototmest row.

```java
  for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if(left > right || top > bottom) break;
```

> - Ultimately, when we check from the bottom to top of the most left column, and make the leftest column move one column inside.

```java
for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if(left > right || top > bottom) break;
```

**How to check if we reach a wall!!!** : `if(left > right || top > bottom) break;` inside a while loop.

## 119. Pascal's Triangle II

```java
  Integer[] arr = new Integer[rowIndex+1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for(int i = 1; i <= rowIndex; i++){
            for(int j = i; j > 0; j--){
                arr[j] +=arr[j-1];
            }
        }
        return Arrays.asList(arr);
```

## Array of characters to string:

```java
        return new String(sArray);
```

## Get a subarray of an array

Arrays.copyOfRange(Object[] src, int from, int to)

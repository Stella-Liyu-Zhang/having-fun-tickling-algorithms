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
>- Ultimately, when we check from the bottom to top of the most left column, and make the leftest column move one column inside.
```java
for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if(left > right || top > bottom) break;
```
**How to check if we reach a wall!!!**  : ```if(left > right || top > bottom) break;``` inside a while loop.

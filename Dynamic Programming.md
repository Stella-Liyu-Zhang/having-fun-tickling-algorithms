## 96. Unique Binary Search Trees

The problem is to calculate the number of unique BST. To do so, we need to define two functions:

1. `G(n)`: the number of unique BST for a sequence of length n.
2. `F(i, n), 1 <= i <= n`: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
3. First of all, given the above definitions, we can see that the total number of unique BST G(n), is the sum of BST F(i) using each number i as a root.
   i.e.
   `G(n) = F(1, n) + F(2, n) + ... + F(n, n)`
4. Base casE: `G(0)=1, G(1)=1. `
5. `F(i, n) = G(i-1) * G(n-i) 1 <= i <= n `

Combining the above two formulas, we obtain the recursive formula for G(n). i.e.
`G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) `

```java
public int numTrees(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        int[] catalan = new int[n+1];
        catalan[0] = 1;
        catalan[1] = 1;
        for(int i = 2; i <= n; i ++){
            for(int j =0; j < i; j ++){
                catalan[i] += catalan[j] * catalan[i-j-1];
            }
        }
        return catalan[n];
}
···
```

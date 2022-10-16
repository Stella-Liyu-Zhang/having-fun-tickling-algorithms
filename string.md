# String

A string is actually an array of unicode characters. You can perform almost all the operations we used in an array. You can try it out by yourself.

However, there are some differences. In this article, we will go through some of them which you should be aware of when dealing with a string. These features might vary a lot from one language to another.

## String has its own compare function.

However, there is a problem:

> Can we use "==" to compare two strings?

It depends on the answer to the question:

> Does the language support operator overloading?
>
> - If the answer is yes (like C++), we may use "==" to compare two strings.
> - If the answer is no (like Java), we may not use "==" to compare two strings. When we use "==", it actually compares whether these two objects are the same object.

Initialize

```java
    String s1 = "Hello World";
    System.out.println("s1 is \"" + s1 + "\"");
    String s2 = s1; //s1 and s2 refered to the same object.
    System.out.println("s2 is another reference to s1.");
    String s3 = new String(s1); //s3 is referred to another object.
    System.out.println("s3 is a copy of s1.");
```

Compare using '=='

```java
         // true since string is immutable and s1 is binded to "Hello World"
        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
        // true since s1 and s2 is the reference of the same object
        System.out.println("s1 and s2: " + (s1 == s2));
        // false since s3 is refered to another new object
        System.out.println("s1 and s3: " + (s1 == s3));
```

Compare using 'equals

```java
        System.out.println("Compared by 'equals':");
        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World")); // true
        System.out.println("s1 and s2: " + s1.equals(s2)); // true
        System.out.println("s1 and s3: " + s1.equals(s3)); //true
```

Compare using 'compareTo'

```java
        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0)); //true
        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0)); //true
        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0)); //true
```

## Immutable or Mutable

Immutable means that you can't change the content of the string once it's initialized.

> 1), In some languages (like C++), the string is mutable. That is to say, you can modify the string just like what you did in an array.

> 2), In some other languages (like Java), the string is immutable. This feature will bring several problems. We will illustrate the problems and solutions in the next article.

In java, if we use `java StringBuilder sb = new StringBuilder(); ` the stringbuilder element is able to be changed after it is created.

## Extra Operations

### concatenate

```java
    String s1 = "Hello World";
    s1 += "!";
    System.out.println(s1);
    Hello World!
```

### find

```java
    System.out.println("The position of first 'o' is: " + s1.indexOf('o'));
    System.out.println("The position of last 'o' is: " + s1.lastIndexOf('o'));
    The position of first 'o' is: 4
    The position of last 'o' is: 7
```

### Get substring

The first index counts, the second index doesn't count.

```java
        System.out.println(s1.substring(6, 11));
```

## Time complexity

For instance, if the length of the string is N, the time complexity of both finding operation and substring operation is O(N).

Never forget to take the time complexity of built-in operations into consideration when you compute the time complexity for your solution.

## 28 Implement strStr()

First is to check the edge cases:

1), Either needle or haystack is empty, we return -1.

2), if the haystack is exactly the same as the needle, we would just need to return 0, and the time complexity would be O(n).

```java
  if (needle.length() == 0 || haystack.length() == 0) return -1;
  if (haystack.equals (needle)) return 0;
```

Next, what we do is that we will use a window of the length of strlength to check one by one while looping through haystack. from index [0, strlength] to index [haystack.length(), haystack.length() + strlength], and to see if the substring matches with the needle.

```java
  int strlength = needle.length();
        int output = -1;
        for (int i = 0; i <= haystack.length() - strlength; i ++){
              if (haystack.substring(i, i + strlength).equals(needle)){
                 return i;
              }
        }
  return -1;
```

## 67. Add Binary

To do this,
First, we will define a StringBuilder element called sb:

```java
StringBuilder sb = new StringBuilder(); // immutability
```

Next, we make 2 pointers that both start from the end of the 2 strings:

```java
int i = a.length() - 1, j = b.length() - 1, carry = 0;
```

1. First, check if there is a carry from the last addition. If so, we add it to the sum:

```java
int sum = carry;
```

2. then, we will add the charAt(j) of both a and b - '0' to the sum.

```java
        if (i >= 0){
                sum += a.charAt(i) - '0';
                i--;
        }
        if (j >= 0){
                sum += b.charAt(j) - '0';
                j--;
        }
```

3. Next, we append the sum%2 to the sb

```java
        sb.append(sum%2);
```

4. Let carry be sum/2

```java
        carry = sum/2;

```

5. if (carry!=0) after the loop, we will append the leftover carry.

```java
        if (carry != 0){
            sb.append(carry);
        }
```

6. Reverse the whole stringbuilder, and make it to string with toString() method.

```java
        return sb.reverse().toString();
```

## 14. Longest Common Prefix

One thing to notice is that Prefix is the substring that starts from the first index of a string!!!

1. First, we sort the array in the ascending order so that we only need to compare the first and the last string.

```java
 public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
```

Next, we will compare each index from the first to the last index of the shortest string, which is the first string strs[0].length. Whenever there is a character that is different, we will break and no longer need to compare further.

```java
        int c = 0;

        while ( c < first.length()){
            if (first.charAt(c)==(last.charAt(c))){
                c++;
            }else{
                break;
            }
        }
```

If the c never increment and is 0, this means that the whole array of string doesn't have a single common predix, and we will return an empty string.

```java
       if(c == 0){
           return "";
       }else{
           return strs[0].substring(0,c);
       }
   }
```

The Big O would be the length of the shared prefix, since we only need to compare until the end of the shared prefix.

## 561. Array Partition I

Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

## 151. Reverse Words in a String

```java

  public String reverseWords(String s) {
    if (s == null) return null;

    char[] a = s.toCharArray();
    int n = a.length;

    // step 1. reverse the whole string
    reverse(a, 0, n - 1);
    // step 2. reverse each word
    reverseWords(a, n);
    // step 3. clean up spaces
    return cleanSpaces(a, n);
  }

  void reverseWords(char[] a, int n) {
    int i = 0, j = 0;

    while (i < n) {
      while (i < j || i < n && a[i] == ' ') i++; // skip spaces
      while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
      reverse(a, i, j - 1);                      // reverse the word
    }
  }

  // trim leading, trailing and multiple spaces
  String cleanSpaces(char[] a, int n) {
    int i = 0, j = 0;

    while (j < n) {
      while (j < n && a[j] == ' ') j++;             // skip spaces
      while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
      while (j < n && a[j] == ' ') j++;             // skip spaces
      if (j < n) a[i++] = ' ';                      // keep only one space
    }

    return new String(a).substring(0, i);
  }

  // reverse a[] from a[i] to a[j]
  private void reverse(char[] a, int i, int j) {
    while (i < j) {
      char t = a[i];
      a[i++] = a[j];
      a[j--] = t;
    }
  }
```

## StringBuilder

The append method always adds these characters at the end of the existing character sequence, while the insert method adds the characters at a specified point.

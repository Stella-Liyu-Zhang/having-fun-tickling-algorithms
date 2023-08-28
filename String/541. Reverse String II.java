```java
 public String reverseStr(String s, int k) {
        char[] charArr = s.toCharArray();
        for(int i = 0; i < s.length(); i = i+2*k){
            int start = i;
            int end = Math.min(i+k-1, s.length() - 1);
            while(start < end){
                char temp = charArr[start];
                charArr[start] = charArr[end];
                charArr[end] = temp;
                start++;
                end--;
            }
        }
        return new String(charArr);
    }
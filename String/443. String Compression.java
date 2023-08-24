class Solution {
    /*
    use j to iterate through, 
    how many items following j are the same

    if j - i >1, we compress


    */
    public int compress(char[] chars) {
        int index = 0; //which also represents the new length of the compressed array
        int i = 0;
        while(i < chars.length){
            int j = i;
            while(j < chars.length && chars[i] == chars[j]){
                j ++;
            }
            chars[index ++] = chars[i];
            if(j-i > 1){
                String count = j-i + "";
                for(char c: count.toCharArray()){
                    chars[index++] = c;
                }
            }
            i = j;
        }
        return index;
    }
}
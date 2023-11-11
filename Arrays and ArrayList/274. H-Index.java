class Solution {
    /*
    sort in descending order
    Find the length of the largest square in the histogram
    citations = paper = h

    */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        //find h-index by linear search
        while(i < citations.length && citations[citations.length - i - 1] > i){
            i ++;
        }
        return i;
    }
}
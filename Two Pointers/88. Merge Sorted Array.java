class Solution {
    /*
    sorted, 
    nums1
    nums2
    go from the end, ach time

    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m-1;
        int ptr2 = n-1;
        int ptr = m+n-1;
        while(ptr2 >= 0){
            if(ptr1 >= 0 && nums1[ptr1] > nums2[ptr2]){
                nums1[ptr] = nums1[ptr1];
                ptr1 --;
            }else{
                nums1[ptr] = nums2[ptr2];
                ptr2 --;
            }

            ptr --;
        }
    }
}
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();
        for(int i: nums1){
            set1.add(i);
        }
        for(int j: nums2){
            if(set1.contains(j)){
                intersection.add(j);
            }
        }
        int[] output = new int[intersection.size()];
        int i = 0;
        for(int element: intersection){
            output[i++] = element;

        }
        return output;
    }
}
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i: nums1){
            set1.add(i);
        }
        for(int j: nums2){
            set2.add(j);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int j: nums2){
            if(set1.contains(j)){
                set1.remove(j);
            }
        }
        for(int i : nums1){
            if(set2.contains(i)){
                set2.remove(i);
            }
        }
        list1.addAll(set1);
        list2.addAll(set2);
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}

class Solution {
    /*
    Time complexity: O(N+M)O(N + M)O(N+M).
    Space complexity: O(max(N,M))O(max(N, M))O(max(N,M)).
    he method getElementsOnlyInFirstList need to store elements in the set. In the first call, it would be nums1 elements and in the second call, it would be nums2 elements. The space required to store the output list is not considered part of space complexity, and hence the total space complexity would be equal to O(max(N,M))O(max(N, M))O(max(N,M)).
    */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(getElementsOnlyInFirstList(nums1, nums2), getElementsOnlyInFirstList(nums2, nums1));
    }

    private List<Integer> getElementsOnlyInFirstList(int[] nums1, int[] nums2) {
        Set<Integer> onlyinNums1 = new HashSet<>();
        Set<Integer> elemenNums2 = new HashSet<>();
        for(int j: nums2){
            elemenNums2.add(j);
        }
        for(int i : nums1){
            if(!elemenNums2.contains(i)){
                onlyinNums1.add(i);
            }
        }
        return new ArrayList<>(onlyinNums1);
    }
}
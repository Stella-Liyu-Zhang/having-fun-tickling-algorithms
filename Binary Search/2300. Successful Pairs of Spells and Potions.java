class Solution {
    /*
    spells.length*potions.length
    binary search,
    see how many multiplication results >= success

Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
Output: [4,0,3]
Explanation:
- 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
- 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
- 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
Thus, [4,0,3] is returned.

    */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int result[] = new int[spells.length];
        for(int i = 0; i < spells.length; i++){
            int minIndex = binarySearch(potions, spells[i], success);
            result[i] = potions.length - minIndex;
        }
        return result;
    }
    private int binarySearch (int[] potions, int spell, long success){
        int left = 0;
        int right = potions.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            long product = (1l * spell) * potions[mid];
            if(product < success){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return left;
    }
}
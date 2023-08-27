/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low <= high){
            int mid =  low + (high-low)/2;
            if(guess(mid) == 0){
                return mid;
            }else if (guess(mid) == -1){
                high = mid - 1;
            }else if (guess(mid) == 1){
                low = mid + 1;
            }
        }
        return -1;
    }
}
//Ternary Search
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low <= high){
            int first =  low + (high-low)/3;
            int second = low + (high-low)*2/3;
            if(guess(first) == 0){
                return first;
            }else if (guess(second) == 0){
                return second;
            }else if(guess(first) == -1){
                high = first -1; 
            }else if(guess(first) == 1){
                low = first +1;
            }else if (guess(second) == -1){
                high = second - 1;
            }else if (guess(second) == 1){
                low = second + 1;
            }
        }
        return -1;
    }
}
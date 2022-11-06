/*
 * For each string compute:
    [ Char[0]^Number  X  Char[1]^Number   X   …… (All character of String[0])  +
    Char[0]^Number   X Char[1]^Number    X   …… (All character of String[1])  +
    …………… ] is Even Number or Odd Number ?
    Here Char[i] is the ASCII value of character.
    For example:
    For input: abc bd    and 2
    =  (97^2  X   98^2   X    99^2)  + (98^2   X   100^2)

    The catch here is not to compute complex mathematical formulas.
    - Even^AnyNumber = Even & 
    - Odd^AnyNumber = Odd

    So you do not need to compute the powers.
    2. Even X Any Number = Even
    Odd X Odd = Odd
    So you just need to identify whether there is any even number present in the multiplication.
    3. For sum: if Odd numbers occur odd times, final sum will be Odd.
    So you need to compute the odd count
 */

public static  boolean checkComputation(String data[]){
    boolean isStringEvenArray[] = new boolean[data.length] ;
    int tempVal;
    boolean isEvenPresent = false;
    for(int i=0; i<data.length;i++){
        isEvenPresent= false;
        for(int j=0; j<data[i].length();j++ ){
            tempVal = (int) data[i].charAt(j); // get the ASCII number 
            if(tempVal%2==0){
                isEvenPresent = true; 
            }
        }           
        isStringEvenArray[i] = isEvenPresent;   //isStringEvenArrya[i] will store whether ith string has even ascii, and therefore, is even.       
    }
    int oddCount=0;     
    for(int i=0; i< data.length; i++){            
        if(!isStringEvenArray[i])
            oddCount++;         
    }
    if(oddCount%2!=0)return false; // if odd number occurs old times, final sum will be odd.
    else return true;
}
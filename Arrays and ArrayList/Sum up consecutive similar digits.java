/*
 * 
 * Replace all ranges of consecutive equal digits with their sum
 * 
 */
String solution(String number) {
    Boolean temp = true; //check if there is any consecutive same digit in the previous operation
    String s = ""; //After all the operations done, append it to the original number
    while (temp){
        temp = false; //999433 
        int count = 1; //how many same variable present consecutively
        //convert a char to an int
        int last = number.charAt(0) - '0'; //last will store the last similar value
        //last: 9
        for(int i = 1; i < number.length(); i++){
            if (number.charAt(i) == number.charAt(i-1)){ // if similar than the previous one
                temp = true;
                count ++; //count = 2
            }else{ //if not the same character
                last = last*count;
                s += last;
                last = number.charAt(i) - '0';
                count = 1;
            }
        }
         last *= count; //last = 18
           s += last;   
           number = s;
           s = "";
    }
    return number;
}
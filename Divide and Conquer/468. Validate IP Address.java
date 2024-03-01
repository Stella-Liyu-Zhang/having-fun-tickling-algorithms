class Solution {
    /*
    0 is allowed 
    001 is not
    
    "0.:1fsa:.9dsa:.hgd0:234"
    
    lower english letter of a to j
    upper english letter
    digits
    Leading zeros allowed
    
    boolean validIPv4
        1) trim
        2) if(< 0 || > 355)
        3) if chunks != 0, chunk.substring(0) == 0
    
    boolean validIPv6
        1) trim
        2) if null
         return false
        if (!isDigit() || !isCharacter()){
            return false
        }
        2) length < 0 || length > 5 
        3) if(isCharacter, 'char's acsii > 6 withthin)
        
    Arrays.split(":")
    Arrays.split(".")
    */
    public boolean validIPv4 (String s){
        String[] chunks = s.split("\\.", -1);
        if(chunks.length != 4) return false;
        for(String chunk: chunks){
            if(chunk.length() == 0) return false; //empty
            try{
                int curr = Integer.valueOf(chunk);//1
                if(curr < 0 || curr > 255) return false; //out of bound
                //0001
                if(curr != 0 && chunk.startsWith("0")) return false; //start with 0
                //0000
                if(curr == 0 && chunk.length() != 1) return false;
            }catch (NumberFormatException e){
                return false; //not only contains digits
            }
        }
        return true;
    }
    
    public boolean validIPv6 (String s){
        String[] chunks = s.split(":", -1);
        if (chunks.length != 8) return false;
        for (String chunk : chunks) {
            if (chunk == null || chunk.length() == 0 || chunk.length() > 4) return false;
            for (char c : chunk.toCharArray()) {
                if (!(Character.isDigit(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                    return false; // Not a valid hexadecimal digit
                }
            }
        }
        return true;
    }
    public String validIPAddress(String queryIP) {
        if(validIPv4(queryIP)){
            return "IPv4";
        }else if (validIPv6(queryIP)){
            return "IPv6";
        }
        return "Neither";
    }
   
}
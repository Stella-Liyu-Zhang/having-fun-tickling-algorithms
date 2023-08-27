class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        for(int i = 0; i < senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                rQueue.add(i);
            }else{
                dQueue.add(i);
            }
        }
        while(rQueue.isEmpty() == false && dQueue.isEmpty() == false){
            int rTurn = rQueue.poll();
            int dTurn = dQueue.poll();
            // ONE having a larger index will be banned by a lower index
            // Lower index will again get Turn, so EN-Queue again
            // But ensure its turn comes in the next round only
            if(rTurn < dTurn){
                rQueue.add(rTurn + n);
            }else{
                dQueue.add(dTurn + n);
            }

        }
        if(rQueue.isEmpty()){
            return "Dire";
        }else{
            return "Radiant";
        }
    }
}
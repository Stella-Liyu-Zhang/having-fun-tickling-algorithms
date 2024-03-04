class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList();
        String sample = "123456789";
        int lowDigits = String.valueOf(low).length();
        int highDigits = String.valueOf(high).length();
        for(int i = lowDigits; i <= highDigits; i ++){
            for(int start = 0; start < 10 - i; start ++){
                int num = Integer.parseInt(sample.substring(start, start + i));
                if(num >= low && num <= high){
                    res.add(num);
                }
            }
        }
        return res;
    }
}
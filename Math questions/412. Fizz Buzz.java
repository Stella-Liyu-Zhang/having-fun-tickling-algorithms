class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList(n);
        for(int i = 1; i <= n; i ++){
            ans.add(checkFizz(i));
        }
        return ans;
    }
    private String checkFizz (int n){
        if (n % 3 == 0 && n % 5 == 0){
            return "FizzBuzz";
        }else if(n % 3 == 0){
            return "Fizz";
        }else if (n % 5 == 0){
            return "Buzz";
        }else{
            return String.valueOf(n);
        }
    }
}
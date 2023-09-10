class Solution {
    public String reformatDate(String date) {
        String[] substrings = date.split(" ");
        String year = substrings[2];

        Map<String, String> map = new HashMap();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");

        String month = map.get(substrings[1]);

        char[] days = substrings[0].toCharArray();
        String day = "";
        
        if(Character.isDigit(days[0]) && Character.isDigit(days[1])){
            day = substrings[0].substring(0,2);
        }else if (Character.isDigit(days[0])){
            day = "0" + substrings[0].substring(0,1);
        }

        return year + "-" + month + "-" + day;
    }
}
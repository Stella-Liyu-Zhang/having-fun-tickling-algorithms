class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, String> parent = new HashMap();
        Map<String, Double> ratio = new HashMap();

        for(int i = 0; i < equations.size(); i ++){
            union(parent, ratio, equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i ++){
            String s1 = queries.get(i).get(0), s2 = queries.get(i).get(1);
            if(!parent.containsKey(s1) || !parent.containsKey(s2) || !find(parent, ratio, s1).equals(find(parent, ratio, s2))){
                res[i] = -1.0;
            }else{
                res[i] = ratio.get(s1)/ratio.get(s2);
            }
        }
        return res;
    }

    private void union (Map<String, String> parent, Map<String, Double> ratio, String s1, String s2, double val){
        if (parent.containsKey(s1) == false){
            parent.put(s1,s1);
            ratio.put(s1, 1.0);
        }
        if (parent.containsKey(s2) == false){
            parent.put(s2,s2);
            ratio.put(s2,1.0);
        }
        String p1 = find(parent, ratio, s1);
        String p2 = find(parent, ratio, s2);
        parent.put(p1, p2);
        ratio.put(p1, val * ratio.get(s2) / ratio.get(s1));
    }

    private String find(Map<String, String> parent, Map<String, Double> ratio, String s){
        if (s.equals(parent.get(s))){
            return s;
        }
        String father = parent.get(s);
        String grandpa = find(parent, ratio, father);
        parent.put(s, grandpa);
        ratio.put(s, ratio.get(s) * ratio.get(father));
        return grandpa;
    }
}
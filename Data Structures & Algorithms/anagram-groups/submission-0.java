class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String res=String.valueOf(ch);
            if(!map.containsKey(res)){
                map.put(res,new ArrayList<>());
            }
            map.get(res).add(str);
        }
        List<List<String>> result=new ArrayList<>();
        for(List<String> list:map.values()){
            result.add(list);
        }
        return result;
    }
}

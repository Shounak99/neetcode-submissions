class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            int[] count = new int[26];
            for(char c:str.toCharArray()){
                count[c-'a']++;
            }
            StringBuilder curr=new StringBuilder();
            for(int i=0;i<26;i++){
                curr.append('#').append(count[i]);
            }
            if(!map.containsKey(curr.toString())){
                map.put(curr.toString(),new ArrayList<>());
            }
            
            map.get(curr.toString()).add(str);
        }
        List<List<String>> result=new ArrayList<>();
        for(List<String> list:map.values()){
            result.add(list);
        }
        return result;
    }
}

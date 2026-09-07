class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        int we=0;
        int ws=0;
        int maxRepeating=1;
        int len=0;
        while(we<s.length()){
            char ce=s.charAt(we);
            map.put(ce,map.getOrDefault(ce,0)+1);
            maxRepeating=Math.max(map.get(ce),maxRepeating);
            while(we-ws+1-maxRepeating>k){
                char cs=s.charAt(ws);
                map.put(cs,map.get(cs)-1);
                ws++;
            }
            len=Math.max(len,we-ws+1);
            we++;
        }
        return len;
    }
}

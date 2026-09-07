class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int num:nums){
            if(!map.containsKey(num)){
                int len=map.getOrDefault(num-1,0)+map.getOrDefault(num+1,0)+1;
                map.put(num,len);
                if(map.containsKey(num-1) && map.containsKey(num-map.get(num-1))){
                    map.put(num-map.get(num-1),len);
                }
                if(map.containsKey(num+1) && map.containsKey(num+map.get(num+1))){
                    map.put(num+map.get(num+1),len);
                }
                ans=Math.max(ans,len);
            }
        }
        return ans;
    }
}

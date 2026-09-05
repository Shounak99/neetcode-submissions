class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(Integer key:map.keySet()){
            if(pq.size()<k){
                pq.add(key);
            }
            else{
                if(map.get(key)>map.get(pq.peek())){
                    pq.poll();
                    pq.add(key);
                }
            }
            
        }
        int[] result=new int[pq.size()];
        for(int i=0;i<result.length;i++){
            result[i]=pq.poll();
        }
        return result;
    }
}

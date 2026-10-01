class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        if(hand.length%groupSize!=0){
            return false;
        }
        for(int num:hand){
            if(!map.containsKey(num)){
                map.put(num,1);
                pq.add(num);
            }
            else{
                map.put(num,map.get(num)+1);
            }
        }
            
            while(!pq.isEmpty()){
                int num=pq.poll();
                if(map.get(num)==0){
                    continue;
                }
                if(!makeGroupPossible(num,map,groupSize)){
                    return false;
                }
                if(map.get(num)!=0)
                    pq.add(num);
            }
            return true;
        
    }
        public boolean makeGroupPossible(int num,Map<Integer,Integer> map,int size){
            int curr=0;
            
            while(map.containsKey(num) && map.get(num)>0){
                map.put(num,map.get(num)-1);
                curr++;
                num++;
                if(curr==size){
                    return true;
                }
                
            }
            
            return false;
        }

        
    
}

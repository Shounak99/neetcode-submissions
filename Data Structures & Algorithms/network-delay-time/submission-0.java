class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<Pair<Integer,Integer>>> graph=new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] time:times){
            int u=time[0];
            int v=time[1];
            int w=time[2];
            graph.get(u).add(new Pair<>(v,w));
        }
        Queue<Pair<Integer,Integer>> q=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        int time=0;
        q.add(new Pair<>(k,0));
        int res=Integer.MAX_VALUE;
        
        Set<Integer> isVisited=new HashSet<>();
        while(!q.isEmpty()){
            Pair<Integer,Integer> parent=q.poll();
             if(isVisited.contains(parent.getKey())){
                continue;
             }
            isVisited.add(parent.getKey());
            time=parent.getValue();
        
                for(Pair<Integer,Integer> child:graph.get(parent.getKey())){
                    if(!isVisited.contains(child.getKey())){
                    q.add(new Pair<>(child.getKey(),parent.getValue()+child.getValue()));
                
                    }
                }
                
        }
        if(isVisited.size()==n){
            return time;
        }
        return -1;
    }
}

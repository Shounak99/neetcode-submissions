class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[] prices=new int[n];
            Arrays.fill(prices,Integer.MAX_VALUE);
            prices[src]=0;
            Map<Integer,List<Pair<Integer,Integer>>> graph=new HashMap<>();
            for(int i=0;i<n;i++){
                graph.put(i,new ArrayList<>());
            }
            for(int[] flight:flights){
                int u=flight[0];
                int v=flight[1];
                int cost=flight[2];
                graph.get(u).add(new Pair<>(v,cost));
            }
            Queue<int[]> q=new LinkedList<>();
            
            q.add(new int[]{src,0,0});
            while(!q.isEmpty()){
                int[] parent=q.poll();
                int node=parent[0];
                int stops=parent[1];
                int cost=parent[2];
                if(stops>k){
                    continue;
                }
               
                for(Pair<Integer,Integer> child:graph.get(node)){
                    int edgeWeight=child.getValue();
                    int childNode=child.getKey();
                    if(prices[childNode]>edgeWeight+cost){
                        prices[childNode]=edgeWeight+cost;
                        q.add(new int[]{childNode,stops+1,prices[childNode]});
                    }
                }
            }
            return prices[dst]==Integer.MAX_VALUE?-1:prices[dst];
    }
}

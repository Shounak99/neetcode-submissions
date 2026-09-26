class Solution {
    static class Edge{
        int u;
        int v;
        int cost;
        Edge(int u,int v,int cost){
            this.u=u;
            this.v=v;
            this.cost=cost;
        }
    }
    static class Union{
        int[] root;
        int size;
        Union(int size){
            this.size=size;
            this.root=new int[size];
            for(int i=0;i<size;i++){
                root[i]=i;
            }
        }
        int find(int x){
            if(root[x]==x){
                return x;
            }
            return root[x]=find(root[x]);
        }
        void union(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX!=rootY){
                root[rootY]=rootX;
            }
        }
        boolean isConnected(int x,int y){
            return find(x)==find(y);
        }
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                Edge e=new Edge(i,j,Math.abs(points[i][0]-points[j][0])+
                Math.abs(points[i][1]-points[j][1]));
                pq.add(e);
            }
        }
        Union un=new Union(points.length);
        int cost=0;
        while(!pq.isEmpty()){
            Edge e=pq.poll();
            if(!un.isConnected(e.u,e.v)){
                un.union(e.u,e.v);
                cost+=e.cost;
            }
        }
        return cost;

    }
}

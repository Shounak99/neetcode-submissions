class Solution {
    static class Union{
        int[] root;
        int size;
        Union(int size){
            this.size=size+1;
            root=new int[size+1];
            for(int i=0;i<this.size;i++){
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
            if(root[rootX]!=root[rootY]){
                root[rootY]=rootX;

            }
        }
        boolean isConnected(int x,int y){
            return find(x)==find(y);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer> vertices=new HashSet<>();
        for(int[] edge:edges){
            vertices.add(edge[0]);
            vertices.add(edge[1]);
        }
        Union un=new Union(vertices.size());
        for(int[] edge:edges){
            if(un.isConnected(edge[0],edge[1])){
                return edge;
            }
            un.union(edge[0],edge[1]);
        }
        return new int[0];
    }
}

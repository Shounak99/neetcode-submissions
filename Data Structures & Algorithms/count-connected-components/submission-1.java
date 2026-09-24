class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] isVisited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                count++;
                Queue<Integer> bfs=new LinkedList<>();
                bfs.add(i);
                while(!bfs.isEmpty()){
                    int size=bfs.size();
                    while(size>0){
                        int parent=bfs.poll();
                        isVisited[parent]=true;
                        for(Integer child:graph.get(parent)){
                            if(!isVisited[child]){
                            isVisited[child]=true;
                            bfs.add(child);}
                        }
                        size--;
                    }
                }
            }
        }
        return count;
    }
}

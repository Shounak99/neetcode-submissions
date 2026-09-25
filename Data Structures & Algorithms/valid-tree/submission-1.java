class Solution {
    public boolean validTree(int n, int[][] edges) {
        Queue<Integer> bfs=new LinkedList<>();
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        bfs.add(0);
        boolean[] isVisited=new boolean[n];
        int[] parents =new int[n];
        Arrays.fill(parents,-1);
        
        while(!bfs.isEmpty()){
            int parent=bfs.poll();
            isVisited[parent]=true;
            System.out.print(parent+" ");
            for(Integer child:graph.get(parent)){
                if(!isVisited[child]){
                    isVisited[child]=true;
                    bfs.add(child);
                    parents[child]=parent;
                }
                else if(isVisited[child] && child!=parents[parent]){
                    System.out.print(child+" ");
                    return false;
                }
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                return false;
            }
        }
        return true;
    }
}

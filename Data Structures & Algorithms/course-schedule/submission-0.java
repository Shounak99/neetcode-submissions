class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            graph.put(i,new ArrayList<>());
        }
        int[] inDegree=new int[numCourses];
        for(int[] p:prerequisites){
            int u=p[0];
            int v=p[1];
            inDegree[v]++;
            graph.get(u).add(v);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int n=0;
        while(!q.isEmpty()){
            int node=q.poll();
            n++;
            for(Integer child:graph.get(node)){
                inDegree[child]--;
                if(inDegree[child]==0){
                    q.add(child);
                }
            }
        }
        if(n!=numCourses){
            return false;
        }
        return true;
    }
}

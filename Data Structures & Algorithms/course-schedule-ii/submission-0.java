class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result=new int[numCourses];
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            graph.put(i,new ArrayList<>());
        }
        int[] inDegree=new int[numCourses];
        for(int[] p:prerequisites){
            int u=p[1];
            int v=p[0];
            inDegree[v]++;
            graph.get(u).add(v);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int k=0;
        while(!q.isEmpty()){
            Integer parent=q.poll();
            result[k++]=parent;
            for(Integer child:graph.get(parent)){
                inDegree[child]--;
                if(inDegree[child]==0){
                    q.add(child);
                }
            }
        }
        if(k!=numCourses){
            return new int[0];
        }
        return result;
    }
}

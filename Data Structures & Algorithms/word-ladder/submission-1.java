class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
       
        Map<String,List<String>> graph=new HashMap<>();
        for(int i=0;i<wordList.size();i++){
            if(!graph.containsKey(wordList.get(i))){
                graph.put(wordList.get(i),new ArrayList<>());
            }
            for(int j=i+1;j<wordList.size();j++){
               
                  if(!graph.containsKey(wordList.get(j))){
                    graph.put(wordList.get(j),new ArrayList<>());
                  }
                        if(difference(wordList.get(i),wordList.get(j))==1){
                            graph.get(wordList.get(i)).add(wordList.get(j));
                            graph.get(wordList.get(j)).add(wordList.get(i));
                        }
                
            }
        }
        return bfs(graph,beginWord,endWord);
    }
    public int difference(String a,String b){
        int diff=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
            }
        }
        return diff;
        
    }
    public int bfs(Map<String,List<String>> graph,String parent,String dest){
       // System.out.print(graph);
        Queue<String> q=new LinkedList<>();
        q.add(parent);
        Set<String> isVisited=new HashSet<>();
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            count++;
            while(size>0){
            String root=q.poll();
            //System.out.print(root+" ");
            isVisited.add(root);
            
            if(root.equals(dest)){
                return count;
            }
            for(String child:graph.get(root)){
                if(!isVisited.contains(child)){
                    isVisited.add(child);
                    q.add(child);
                }
            }
            size--;
            
        }
        
        }
        return 0;
    }
}

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific=new boolean[heights.length][heights[0].length];
        boolean[][] atlantic=new boolean[heights.length][heights[0].length];
        for(int j=0;j<heights[0].length;j++){
            dfs(0,j,heights,pacific,Integer.MIN_VALUE);
            dfs(heights.length-1,j,heights,atlantic,Integer.MIN_VALUE);
        }
        for(int i=0;i<heights.length;i++){
            dfs(i,0,heights,pacific,Integer.MIN_VALUE);
            dfs(i,heights[0].length-1,heights,atlantic,Integer.MIN_VALUE);
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
        return result;


    }
    public void dfs(int i,int j,int[][] heights,boolean[][] isVisited,int prevHeight){
        if(i<0||i>=heights.length||j<0||j>=heights[0].length||isVisited[i][j]||
        heights[i][j]<prevHeight){
            return ;
        }
        isVisited[i][j]=true;
        dfs(i-1,j,heights,isVisited,heights[i][j]);
        dfs(i+1,j,heights,isVisited,heights[i][j]);
        dfs(i,j-1,heights,isVisited,heights[i][j]);
        dfs(i,j+1,heights,isVisited,heights[i][j]);

    }
}

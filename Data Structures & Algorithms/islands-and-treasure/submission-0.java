class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> bfs=new LinkedList<>();
        int[][] dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    bfs.add(new int[]{i,j});
                    boolean[][] isVisited=new boolean[grid.length][grid[0].length];
                    isVisited[i][j]=true;
                    while(!bfs.isEmpty()){
                        int size=bfs.size();
                        while(size>0){
                            int[] curr=bfs.poll();
                            for(int[] dir:dirs){
                                int x=curr[0]+dir[0];
                                int y=curr[1]+dir[1];
                                if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]!=0 && grid[x][y]!=-1 && !isVisited[x][y]){
                                    isVisited[x][y]=true;
                                    grid[x][y]=Math.min(grid[x][y],grid[curr[0]][curr[1]]+1);
                                    bfs.add(new int[]{x,y});
                                }
                            }
                            size--;
                        }
                    }
                }
            }
        }
    }
}

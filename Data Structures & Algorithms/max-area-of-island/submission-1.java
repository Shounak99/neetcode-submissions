class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int maxArea=0;
        Queue<int[]> bfs=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    bfs.add(new int[]{i,j});
                    grid[i][j]=2;
                    int area=0;
                    while(!bfs.isEmpty()){
                        int size=bfs.size();
                      
                        while(size>0){
                        int[] curr=bfs.poll();
                          area++;
                        for(int[] dir:dirs){
                            int x=curr[0]+dir[0];
                            int y=curr[1]+dir[1];
                            if(x>=0 && x<n && y>=0 && y<m && grid[x][y]==1){
                                grid[x][y]=2;
                                bfs.add(new int[]{x,y});
                            }
                        }
                        size--;
                      }
                    }
                    maxArea=Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }
}

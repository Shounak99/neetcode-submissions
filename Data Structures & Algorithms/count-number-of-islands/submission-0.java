class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> bfs=new LinkedList<>();
        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs.add(new int[]{i,j});
                    while(!bfs.isEmpty()){
                        int size=bfs.size();
                        while(size>0){
                        int[] curr=bfs.poll();
                        size--;
                        for(int[] dir:dirs){
                            int x=curr[0]+dir[0];
                            int y=curr[1]+dir[1];
                            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]=='1'){
                                grid[x][y]='2';
                                bfs.add(new int[]{x,y});
                            }
                        }

                        }
                    }
                }
            }
        }
        return count;
    }
}

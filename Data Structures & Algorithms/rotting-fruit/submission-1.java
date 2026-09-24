class Solution {
    public int orangesRotting(int[][] grid) {
        int count=0;
        Queue<int[]> bfs=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    bfs.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    count++;
                }
            }
        }
        if(count==0){
            return 0;
        }
        int[][] dirs=new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        int t=0;
        while(!bfs.isEmpty()){
            int size=bfs.size();
            while(size>0){
                int[] curr=bfs.poll();
                for(int[] dir:dirs){
                    int x=curr[0]+dir[0];
                    int y=curr[1]+dir[1];
                    if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1){
                        grid[x][y]=2;
                        count--;
                        bfs.add(new int[]{x,y});
                    
                    }
                        if(count==0){
                        break;
                    }
                }
                size--;
                
                if(count==0){
                    break;
                }
            }
            t++;
            if(count==0){
                break;
            }
        }
        return count==0?t:-1;
    }
}

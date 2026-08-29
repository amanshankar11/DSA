class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int area=dfs(grid,i,j);
                    if(area>maxArea) maxArea=area;
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid,int r,int c){
        if(r<0 || r>=grid.length) return 0;
        if(c<0 || c>=grid[0].length) return 0;
        if(grid[r][c]==0) return 0;

        grid[r][c]=0;
        int area=1;

        area+=dfs(grid,r+1,c);
        area+=dfs(grid,r-1,c);
        area+=dfs(grid,r,c-1);
        area+=dfs(grid,r,c+1);
        return area;
    }
}
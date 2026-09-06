class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q=new LinkedList<>();
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        q.offer(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]]='+';
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int i=curr[0];
            int j=curr[1];
            int steps=curr[2];

            if(((i==0 || i==maze.length-1) || (j==0 || j==maze[0].length-1)) && steps!=0){
                return steps;
            }
            for(int[] dir:directions){
                int ni=i+dir[0];
                int nj=j+dir[1];

                if(ni>=0 && ni<maze.length && nj>=0 && nj<maze[0].length && maze[ni][nj]=='.'){
                    maze[ni][nj]='+';
                    q.offer(new int[]{ni,nj,steps+1});
                }
            }
        }
        return -1;
    }
}
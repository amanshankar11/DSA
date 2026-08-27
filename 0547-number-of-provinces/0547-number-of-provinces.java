class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(isConnected,visited,i);
            }
        }
        return count;
    }

    public void dfs(int[][] graph,boolean[] visited,int from){
        visited[from]=true;

        for(int to=0;to<graph.length;to++){
            if(graph[from][to]==1 && !visited[to]){
                dfs(graph,visited,to);
            }
        }
    }
}
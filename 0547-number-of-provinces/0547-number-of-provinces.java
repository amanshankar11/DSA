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

    public void dfs(int[][] graph,boolean[] visited,int vertex){
        visited[vertex]=true;

        for(int element=0;element<graph.length;element++){
            if(graph[vertex][element]==1 && !visited[element]){
                dfs(graph,visited,element);
            }
        }
    }
}
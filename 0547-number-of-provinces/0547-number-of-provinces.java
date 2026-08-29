class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces=0;
        boolean[] visited=new boolean[isConnected.length];
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                provinces++;
                visitProvince(visited,isConnected,i);
            }
        }
        return provinces;
    }
    private void visitProvince(boolean[] visited,int[][] graph,int from){
        visited[from]=true;
        for(int i=0;i<graph[from].length;i++){
            if(graph[from][i]==1 && !visited[i]){
                visitProvince(visited,graph,i);
            }
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        boolean[] visited=new boolean[n];
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            int from=connections[i][0];
            int to=connections[i][1];
            list.get(from).add(to);
            list.get(to).add(from);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(visited,list,i);
            }
        }
        return count-1;
    }
    private void dfs(boolean[] visited,List<List<Integer>> graph,int from){
        visited[from]=true;
        for(int to=0;to<graph.get(from).size();to++){
            if(!visited[graph.get(from).get(to)]){
                dfs(visited,graph,graph.get(from).get(to));
            }
        }
    }
}
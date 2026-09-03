class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        long ans=0;
        long prev=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int count=dfs(visited,graph,i);
                ans+=prev*count;
                prev+=count;
            }
        }

        return ans;
    }
    private int dfs(boolean[] visited,List<List<Integer>> graph,int from){
        visited[from]=true;
        int count=1;
        for(int to=0;to<graph.get(from).size();to++){
            if(!visited[graph.get(from).get(to)]){
                count+=dfs(visited,graph,graph.get(from).get(to));
            }
        }
        return count;
    }
}
class Solution {
    public boolean validPath(int n,int[][] edges,int source,int destination){
        if(n==1)return true;
        List<ArrayList<Integer>> g=new ArrayList<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        return helper(visited,g,source,destination);
    }
    private boolean helper(boolean[] visited,List<ArrayList<Integer>> graph,int source,int destination){
        visited[source]=true;
        if(source==destination) return true;
        for(int i=0;i<graph.get(source).size();i++){
            if(!visited[graph.get(source).get(i)]){
                if(helper(visited,graph,graph.get(source).get(i),destination))return true;
            }
        }
        return false;
    }
}
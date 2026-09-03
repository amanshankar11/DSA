class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=edges.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<=edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];

            boolean[] visited=new boolean[graph.size()];

            if(dfs(visited,graph,from,to)){
                return new int[]{from,to};
            }

            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return new int[0];
    }
    private boolean dfs(boolean[] visited,List<List<Integer>> graph,int from,int to){
        if(from==to) return true;
        visited[from]=true;
        for(int i=0;i<graph.get(from).size();i++){
            if(!visited[graph.get(from).get(i)]){
                if(dfs(visited,graph,graph.get(from).get(i),to)){
                    return true;
                }
            }
        }
        return false;
    }
}
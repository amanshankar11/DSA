class Solution {
    public int countCompleteComponents(int n,int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited=new boolean[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                int[] result=dfs(graph,visited,i);

                int vertices=result[0];
                int edgesCount=result[1];

                if(edgesCount==vertices*(vertices-1)){
                    count++;
                }
            }
        }

        return count;
    }

    private int[] dfs(List<List<Integer>> graph,boolean[] visited,int from){
        visited[from]=true;

        int vertices=1;
        int edges=graph.get(from).size();

        for(int to=0;to<graph.get(from).size();to++){
            if(!visited[graph.get(from).get(to)]){
                int[] result=dfs(graph,visited,graph.get(from).get(to));

                vertices+=result[0];
                edges+=result[1];
            }
        }

        return new int[]{vertices,edges};
    }
}
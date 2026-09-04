class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<graph.length;i++) g.add(new ArrayList<>());
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                g.get(i).add(graph[i][j]);
            }
        }
        for(int i=0;i<g.size();i++){
            if(color[i]==0){
                if(!bfs(g,color,i)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(List<List<Integer>> graph,int[] color,int start){
        Queue<Integer> q=new LinkedList<>();
        // visited[start]=true;
        color[start]=1;
        q.offer(start);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<graph.get(curr).size();i++){
                if(color[graph.get(curr).get(i)]==0){
                    color[graph.get(curr).get(i)]=-color[curr];
                    q.offer(graph.get(curr).get(i));
                }
                else if(color[curr]==color[graph.get(curr).get(i)]){
                    return false;
                }
            }
        }
        return true;
    }
}
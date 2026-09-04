class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        // for(int i=0;i<graph.length;i++) g.add(new ArrayList<>());
        // for(int i=0;i<graph.length;i++){
        //     for(int j=0;j<graph[i].length;j++){
        //         g.get(i).add(graph[i][j]);
        //     }
        // }
        for(int i=0;i<graph.length;i++){
            if(color[i]==0){
                if(!bfs(graph,color,i)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(int[][] graph,int[] color,int start){
        Queue<Integer> q=new LinkedList<>();
        color[start]=1;
        q.offer(start);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<graph[curr].length;i++){
                if(color[graph[curr][i]]==0){
                    color[graph[curr][i]]=-color[curr];
                    q.offer(graph[curr][i]);
                }
                else if(color[curr]==color[graph[curr][i]]){
                    return false;
                }
            }
        }
        return true;
    }
}
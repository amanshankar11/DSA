class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] g=new ArrayList[n+1];
        for(int i=0;i<=n;i++) g[i]=new ArrayList<>();
        for(int i=0;i<dislikes.length;i++){
            g[dislikes[i][0]].add(dislikes[i][1]);
            g[dislikes[i][1]].add(dislikes[i][0]);
        }
        int[] color=new int[n+1];
        for(int i=1;i<g.length;i++){
            if(color[i]==0){
                if(!bfs(g,color,i)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(List<Integer>[] graph,int[] color,int start){
        Queue<Integer> q=new LinkedList<>();
        color[start]=1;
        q.offer(start);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<graph[curr].size();i++){
                if(color[graph[curr].get(i)]==0){
                    color[graph[curr].get(i)]=-color[curr];
                    q.offer(graph[curr].get(i));
                }
                else if(color[curr]==color[graph[curr].get(i)]){
                    return false;
                }
            }
        }
        return true;
    }
}
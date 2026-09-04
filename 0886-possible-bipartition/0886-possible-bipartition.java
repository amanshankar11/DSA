class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<=n;i++) g.add(new ArrayList<>());
        for(int i=0;i<dislikes.length;i++){
            g.get(dislikes[i][0]).add(dislikes[i][1]);
            g.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        int[] color=new int[n+1];
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
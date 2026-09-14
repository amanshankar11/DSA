class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> g=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        int[] indegree=new int[graph.length];
        for(int i=0;i<graph.length;i++) g.add(new ArrayList<>());
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                g.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr);

            for(int i=0;i<g.get(curr).size();i++){
                indegree[g.get(curr).get(i)]--;

                if(indegree[g.get(curr).get(i)]==0){
                    q.offer(g.get(curr).get(i));
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        for(int[] row:prerequisites){
            int u=row[0];
            int v=row[1];
            indegree[u]++;
            graph.get(v).add(u);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) q.offer(i);
        }
        int index=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            index++;
            for(int i=0;i<graph.get(curr).size();i++){
                indegree[graph.get(curr).get(i)]--;
                if(indegree[graph.get(curr).get(i)]==0){
                    q.offer(graph.get(curr).get(i));
                }
            }
        }
        if(index!=numCourses) return false;
        return true;
    }
}
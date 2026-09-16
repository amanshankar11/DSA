class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            return new ArrayList<>(Arrays.asList(0));
        }
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];

            g.get(u).add(v);
            g.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(degree[i] == 1){
                q.offer(i);
            }
        }

        int remaining = n;

        while(remaining>2){
            int size = q.size();
            remaining -= size;
            for(int i=0;i<size;i++){
                int leaf = q.poll();
                for(int j=0;j<g.get(leaf).size();j++){
                    degree[g.get(leaf).get(j)]--;
                    if(degree[g.get(leaf).get(j)] == 1){
                        q.offer(g.get(leaf).get(j));
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;
    }
}

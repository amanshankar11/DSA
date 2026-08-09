class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n=parent.length;
        List<List<Integer>> tree=new ArrayList<>();
        for(int i=0;i<n;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            tree.get(parent[i]).add(i);
        }

        int[] dpth=new int[n];
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(0);
        dpth[0]=1;
        int h=1;
        while(!q.isEmpty()){
            int take=q.poll();
            for(int child:tree.get(take)){
                dpth[child]=dpth[take]+1;
                h=Math.max(h,dpth[child]);
                q.offer(child);
            }
        }
        long ans=0;
        for(int i=0;i<n;i++){
            ans+=(long)nums[i]*(h-dpth[i]+1);
        }
        return ans;
    }
}
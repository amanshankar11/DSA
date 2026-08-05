class Solution {
    private boolean helper(boolean[] visited,int[] nums,int i){
        if(i>=nums.length || i<0)return false;
        if(nums[i]==0)return true;
        if(visited[i]==true) return false;
        visited[i]=true;
        boolean check=helper(visited,nums,i+nums[i]);
        boolean check2=helper(visited,nums,i-nums[i]);
        return check||check2;
    }
    public boolean canReach(int[] arr, int start) {
        boolean[] vis=new boolean[arr.length+1];
        return helper(vis,arr,start);
    }
}
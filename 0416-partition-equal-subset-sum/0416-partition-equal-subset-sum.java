class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int x:nums)total+=x;
        if(total%2!=0) return false;
        int target=total/2;
        for(int i=0;i<(1<<nums.length);i++){
            int sum=0;
            for(int j=0;j<nums.length;j++){
                if(((i>>j)&1)==1){
                    sum+=nums[j];
                }
            }
            if(sum==target)return true;
        }
        return false;
    }
}
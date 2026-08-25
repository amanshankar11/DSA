class Solution {
    public int missingMultiple(int[] nums, int k) {
        int[] mul=new int[102];
        Set<Integer> set=new HashSet<>();
        int ans=0;
        for(int i=1;i<mul.length;i++){
            mul[i]=k*i;
        }
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=1;i<mul.length;i++){
            if(!set.contains(mul[i])){
                ans=mul[i];
                break;
            }
        }
        return ans;
    }
}
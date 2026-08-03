class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<(1 << nums.length);i++){
            List<Integer> subset=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if(((i>>j)&1)==1){
                    subset.add(nums[j]);
                }
            }
            list.add(subset);
        }
        return list;
    }
}
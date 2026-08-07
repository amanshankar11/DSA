class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        int max=nums[0];
        int min=nums[0];
        for(int i:nums){
            max=Math.max(i,max);
            min=Math.min(i,min);
            set.add(i);
        }
        int total=0;
        for(int i=min;i<=max;i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}
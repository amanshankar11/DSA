class Solution {
    public int removeDuplicates(int[] nums) {
        int backward=0;
        int forward=1;
        while(forward<nums.length){
            if(nums[backward]==nums[forward]){
                forward++;
            }
            else if(nums[backward]!=nums[forward]){
                backward++;
                nums[backward]=nums[forward];
                forward++;
            }
        }
        return backward+1;
    }
}
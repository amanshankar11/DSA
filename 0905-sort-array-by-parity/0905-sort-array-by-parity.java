class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] res=new int[nums.length];
        int left=0;
        int right=res.length-1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                res[left]=nums[i];
                left++;
            }else{
                res[right]=nums[i];
                right--;
            }
        }
        return res;
    }
}
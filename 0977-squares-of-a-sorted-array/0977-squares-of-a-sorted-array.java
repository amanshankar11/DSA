class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums[i]=nums[i]*-1;
            }
        }
        
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
            if(nums[i]<nums[j]){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        return nums;
    }
}
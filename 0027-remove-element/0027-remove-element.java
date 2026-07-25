class Solution {
    public int removeElement(int[] nums, int val) {
        int back=0;
        int front=0;
        while(front<nums.length){
            if(nums[front]==val ){
                front++;
                if(front>nums.length-1){
                    break;
                }
            }
            if(nums[front]!=val){
                int temp=nums[front];
                nums[front]=nums[back];
                nums[back]=temp;
                back++;
                front++;
            }
        }
        return back;
    }
}
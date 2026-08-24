class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] == 0 &&
                (i == 0 || nums[i - 1] == 0) &&
                (i == nums.length - 1 || nums[i + 1] == 0)) {
                
                nums[i] = 1;
                n--;
            }
            
            if (n <= 0) {
                return true;
            }
        }

        return false;
    }
}
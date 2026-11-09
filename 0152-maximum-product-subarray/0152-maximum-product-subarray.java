class Solution {
    public int maxProduct(int[] nums) {
       int n = nums.length;
 
        // No non-empty subarray exists.
        if (n == 0) {
            return 0;
        }
 
        int currentMax = nums[0];
        int currentMin = nums[0];
        int maxProduct = nums[0];
 
        for (int index = 1; index < n; index++) {
            int currentValue = nums[index];
 
            /*
             * Preserve both previous states because
             * a negative value can swap their roles.
             */
            int previousMax = currentMax;
            int previousMin = currentMin;
 
            /*
             * Either start fresh or extend one of
             * the previous product subarrays.
             */
            currentMax = Math.max(
                currentValue,
                Math.max(
                    previousMax * currentValue,
                    previousMin * currentValue
                )
            );
 
            currentMin = Math.min(
                currentValue,
                Math.min(
                    previousMax * currentValue,
                    previousMin * currentValue
                )
            );
 
            // Record the best product found anywhere so far.
            if (currentMax > maxProduct) {
                maxProduct = currentMax;
            }
        }
        return maxProduct; 
    }
}
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;

        for (int num : nums) {
            if (num == 1) ones++;
        }

        if (ones > 0) {
            return n - ones;
        }

        int minLen = n + 1;

        for (int i = 0; i < n; i++) {
            int gcd = 0;

            for (int j = i; j < n; j++) {
                gcd = gcd(gcd, nums[j]);

                if (gcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        if (minLen == n + 1) {
            return -1;
        }

        return (minLen - 1) + (n - 1);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int val : freq) {
            length += (val / 2) * 2;

            if (val % 2 == 1) {
                hasOdd = true;
            }
        }

        if (hasOdd) {
            length++;
        }
        return length;
    }
}
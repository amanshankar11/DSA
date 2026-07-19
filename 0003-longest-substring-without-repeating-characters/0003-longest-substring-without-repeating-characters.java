class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int start = 0;
        int maxLen = 1;
        char[] str = s.toCharArray();
        int end = 1;
        set.add(str[0]);
        while(end<str.length) {
            while (set.contains(str[end])) {
                set.remove(str[start]);
                start++;
            }
            set.add(str[end]);
            maxLen=Math.max(maxLen,end-start+1);
            end++;
        }
        return maxLen;
    }
}
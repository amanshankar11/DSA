class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        Set<Character> set=new HashSet<>();
        int left=0;
        int ans=1;
        for(int right=0;right<s.length();right++){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
            }
            else{
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            ans=Math.max(ans,set.size());
        }
        return ans;
    }
}
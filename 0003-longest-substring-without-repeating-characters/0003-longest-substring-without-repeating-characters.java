class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int left=0;
        int len=0;
        for(int right=0;right<s.length();right++){
            char r= s.charAt(right);
            map.put(r,map.getOrDefault(r,0)+1);

            while(map.get(s.charAt(right))>1){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }

            len=Math.max(len,right-left+1);
        }
        return len;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        Map<Character,Integer> map=new HashMap<>();
        int maxLen=0;
        int start=0;
        char[] str=s.toCharArray();
        for(int i=0;i<str.length;i++){
            if(map.containsKey(str[i])){
                start=Math.max(start,map.get(str[i])+1);
            }
            map.put(str[i],i);
            maxLen=Math.max(maxLen,i-start+1);
        }
        return maxLen;
    }
}
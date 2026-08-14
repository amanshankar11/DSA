class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq=new int[26];
        int left=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;

            while(freq[ch-'a']>2){
                char c=s.charAt(left);
                freq[c-'a']--;
                left++;
            }

            ans=Math.max(ans,i-left+1);
        }
        return ans;
    }
}
class Solution {
    public int characterReplacement(String s, int k) {
        // Map<Character,Integer> map=new HashMap<>();
        int[] freq=new int[26];
        int left=0;
        int max=0;
        int max2=0;
        int ans=1;
        for(int right=0;right<s.length();right++){
            char r=s.charAt(right);
            freq[r-'A']++;
            // map.put(r,map.getOrDefault(r,0)+1);
            // max=Math.max(max,map.get(r));

            max2=Math.max(max2,freq[r-'A']);

            while((right-left+1) -max2 > k){
                char l=s.charAt(left);
                // map.put(l,map.get(l)-1);
                freq[l-'A']--;
                left++;
            }

            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}
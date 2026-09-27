class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sf=new int[26];
        int[] ft=new int[26];

        for(char ch:s.toCharArray()){
            sf[ch-'a']++;
        }

        for(char ch:t.toCharArray()){
            ft[ch-'a']++;
        }

        for(int i=0;i<26;i++){
            if(sf[i]!=ft[i]) return false;
        }

        return true;
    }
}
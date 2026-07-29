class Solution {
    public String smallestPalindrome(String s) {
        int[] freq=new int[26];
        for(int i=0;i<s.length()/2;i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder str=new StringBuilder();
        for(int i=0;i<26;i++){
            int a=freq[i];
            while(a>0){
                str.append((char)('a'+i));
                a--;
            }
        }
        StringBuilder ans=new StringBuilder();
        ans.append(str);
        if(s.length()%2==1) ans.append(s.charAt(s.length()/2));
        ans.append(str.reverse());
        return ans.toString();
    }
}
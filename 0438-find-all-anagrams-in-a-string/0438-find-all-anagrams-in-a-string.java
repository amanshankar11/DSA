class Solution {
    public List<Integer> findAnagrams(String s, String p) {
          List<Integer> res=new ArrayList<>();
        if(p.length()>s.length()) return res;
        int[] s1=new int[26];
        int[] p1=new int[26];

        for(int i=0;i<p.length();i++){
            p1[p.charAt(i)-'a']++;
        }
        int window=p.length();
        for(int i=0;i<window;i++){
            s1[s.charAt(i)-'a']++;
        }
        
        if(anagrams(s1,p1)) res.add(0);

        for(int i=window;i<s.length();i++){
            s1[s.charAt(i)-'a']++;
            s1[s.charAt(i-window)-'a']--;
            if(anagrams(p1,s1)) res.add(i-window+1);
        }
        return res;
        
    }
    private boolean anagrams(int[] a,int[] b){
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i])return false;
        }
        return true;
    }
}
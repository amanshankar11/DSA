class Solution {
    public boolean isVowel(char ch){
        String s="aeiou";
        if(s.indexOf(ch)!=-1) return true;
        return false;
    }
    public int maxVowels(String s, int k) {
        int maxVowel=0;
        // char[] res=s.toCharArray();
        for(int i=0;i<k;i++){
            if(isVowel(s.charAt(i))) maxVowel++; 
        }
        int vowels=maxVowel;
        for(int i=k;i<s.length();i++){
            if(isVowel(s.charAt(i))) vowels++;
            if(isVowel(s.charAt(i-k))) vowels--;

            maxVowel=Math.max(maxVowel,vowels);
        }
        return maxVowel;
    }
}

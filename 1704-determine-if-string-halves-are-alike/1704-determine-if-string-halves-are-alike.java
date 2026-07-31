class Solution {
    private boolean isVowel(char ch){
        String vowel="aeiouAEIOU";
        return vowel.indexOf(ch)!=-1;
    }
    public boolean halvesAreAlike(String s) {
        int first=0;
        int second=0;
        int n=s.length();
        for (int i=0;i<n/2;i++) {
            if (isVowel(s.charAt(i))) {
                first++;
            }
        }
        for (int i=n/2;i<n;i++) {
            if (isVowel(s.charAt(i))) {
                second++;
            }
        }
        return first == second;
    }
}
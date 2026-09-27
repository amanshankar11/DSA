class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] letter=new int[26];
        String str=sentence.toLowerCase();
        for(int i=0;i<str.length();i++){
            letter[str.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(letter[i]<1) return false;
        }
        return true;
    }
}
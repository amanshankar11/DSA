class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] letter=new int[26];
        for(int i=0;i<sentence.length();i++){
            letter[sentence.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(letter[i]<1) return false;
        }
        return true;
    }
}
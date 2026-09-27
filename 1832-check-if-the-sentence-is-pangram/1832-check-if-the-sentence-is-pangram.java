class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] letter=new int[26];
        for(char ch:sentence.toCharArray()){
            letter[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(letter[i]<1) return false;
        }
        return true;
    }
}
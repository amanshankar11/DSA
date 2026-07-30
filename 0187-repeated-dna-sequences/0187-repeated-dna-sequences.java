class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen=new HashSet<>();
        Set<String> repeat=new HashSet<>();
        for(int i=0;i<=s.length()-10;i++){
            String sub=s.substring(i,i+10);

            if(!seen.add(sub)) repeat.add(sub);
        }
        return new ArrayList<>(repeat);
    }
}
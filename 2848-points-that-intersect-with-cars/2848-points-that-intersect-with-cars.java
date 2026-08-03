class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.size();i++){
            int start=nums.get(i).get(0);
            int end=nums.get(i).get(1);
            for(int j=start;j<=end;j++){
                set.add(j);
            }
        }
        return set.size();
    }
}
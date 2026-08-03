class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
       int[] prefix=new int[nums.length+1];
       prefix[0]=0;
       map.put(0,1);
       for(int i=0;i<nums.length;i++){
        prefix[i+1]=prefix[i]+nums[i];
       }
       int count=0;
       for(int i=1;i<prefix.length;i++){
        int div=((prefix[i]%k)+k)%k;
        if(map.containsKey(div)) count+=map.get(div);
        map.put(div,map.getOrDefault(div,0)+1);
       }
       return count;
    }
}
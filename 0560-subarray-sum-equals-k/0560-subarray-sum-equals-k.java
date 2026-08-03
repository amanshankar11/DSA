class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix=new int[nums.length+1];
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        prefix[0]=0;
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        int count=0;
        for(int i=1;i<prefix.length;i++){
            int sum=prefix[i];
            int rem=prefix[i]-k;
            if(map.containsKey(rem)) count+=map.get(rem);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
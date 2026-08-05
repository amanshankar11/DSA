class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length==1 && k==nums[0]) return nums[0];
        if(nums.length==1 && k!=nums[0]) return 0;
        int[] prefix=new int[nums.length];
        Map<Integer,Integer> map=new HashMap<>();
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int ans=0;
        map.put(0,1);
        for(int right=0;right<nums.length;right++){
            int target=prefix[right]-k;
            if(map.containsKey(target)) ans+=map.get(target);
            map.put(prefix[right],map.getOrDefault(prefix[right],0)+1);
        }
        return ans;
    }
}
class Solution {
    private int valueTime(int[] nums,int k){
        Map<Integer,Integer> map=new HashMap<>();
        int left=0;
        int count=0;
        int right=0;
        while(right<nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);

                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count+=right-left+1;
            right++;
        }

        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count=valueTime(nums,k)-valueTime(nums,k-1);
        // for(int start=0;start<nums.length;start++){
        //     Set<Integer> set=new HashSet<>();
        //     for(int end=start;end<nums.length;end++){
        //         set.add(nums[end]);
        //         if(set.size()==k) count++;
        //     }
        // }
        return count;
    }
}
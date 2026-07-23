class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int check1=0;
        int check2=0;
        int k=0;
        int[] arr=new int[m+n];
        while(check1<m && check2<n){
            if(nums1[check1]<=nums2[check2]){
                arr[k++]=nums1[check1++];
            }else{
                arr[k++]=nums2[check2++];
            }
        }
        while(check1<m){
            arr[k++]=nums1[check1++];
        }
        while(check2<n){
            arr[k++]=nums2[check2++];
        }
        for(int i=0;i<m+n;i++){
            nums1[i]=arr[i];
        }
    }
}
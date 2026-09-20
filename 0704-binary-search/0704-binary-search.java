class Solution {
    public int search(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;
        return Helper(nums,s,e,target);
    }
    public int Helper(int[] nums,int s,int e,int target){
        if(s>e){
            return -1;
        }
       int  mid=s+(e-s)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]>target){
            e=mid-1;
        }
        else{
            s=mid+1;
        }
        return Helper(nums,s, e,target);
    }
}
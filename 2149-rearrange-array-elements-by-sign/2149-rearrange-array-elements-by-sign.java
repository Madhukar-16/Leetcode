class Solution {
    public int[] rearrangeArray(int[] nums) {
        int length=nums.length;
        int [] positive=new int [length];
        int [] negative =new int [length];
        int n=0,p=0;
         for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                positive[p]=nums[i];
                p++;
            }
            else{
                negative[n]=nums[i];
                n++;
            }
         }
          n=0;
          p=0;
         for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=positive[p]; 
                p++;
            }
            else{
                nums[i]=negative[n];
                n++;
            }
         }
         return nums;
    }
}
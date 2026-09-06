class Solution {
    public static void Reverse( int [] nums,int k,int j){
            while(k<j){
                int temp=nums[k];
                nums[k]=nums[j];
                nums[j]=temp;
                k++;
                j--;
    }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int indx=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                indx=i;
                break;
            }
        }
        if(indx==-1){
            Reverse(nums,0,n-1);
            return  ;
        }
        for(int i=n-1;i>=indx;i--){
            if(nums[i]>nums[indx]){
                int temp=nums[i];
                nums[i]=nums[indx];
                nums[indx]=temp;
                break;
            }
        }
            //Reverse 
             Reverse(nums,indx+1,n-1);
            
        }
        
    
}
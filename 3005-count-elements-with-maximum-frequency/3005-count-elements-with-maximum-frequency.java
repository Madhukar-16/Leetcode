class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
       int count =0;
         int MaxFreq=-1;
        for(int i:map.keySet()){
           
            int freq=map.get(i);
            if(freq>MaxFreq){
                MaxFreq=freq;
                count =0;
            }
            if(freq==MaxFreq){
                count =count +1;
            }
            }
        return MaxFreq*count;
    }
}
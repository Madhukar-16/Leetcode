class Solution {
    public int majorityElement(int[] nums) {
         int MaxFreq=0;
         int ans=0;
    HashMap<Integer,Integer> map= new HashMap<>();
    for(int i=0;i<nums.length;i++){
         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
   
    for(int i:map.keySet()){
        int freq=map.get(i);
        if(freq>MaxFreq){
            MaxFreq=freq;
            ans=i;

        }
    }
    return ans;
    }
}
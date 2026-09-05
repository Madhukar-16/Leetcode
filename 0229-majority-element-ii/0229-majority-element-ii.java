class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }
        int freq=nums.length/3;
        for(int i:map.keySet()){
            int count=map.get(i);
            if(count>freq){
                list.add(i);
            }
        }
        return list;
    }
}
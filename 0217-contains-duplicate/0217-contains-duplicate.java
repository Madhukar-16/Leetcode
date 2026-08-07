import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
      HashSet<Integer> map=new HashSet <>();
        for(int el:nums){
            if(map.contains(el)) return true;
            map.add(el);
        }
        return false;
    }
}
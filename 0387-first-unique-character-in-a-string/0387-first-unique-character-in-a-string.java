class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        Queue<Character>q=new LinkedList<>();
       int n=s.length();
       for(int i=0;i<n;i++){
        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
          q.add(s.charAt(i));
       }
       int ans=-1;
       for(int i=0;i<n;i++){
        char temp=q.remove();
        if(map.get(temp)==1){
            ans=i;
             break;
        }
       }
       return ans; 
    }
}
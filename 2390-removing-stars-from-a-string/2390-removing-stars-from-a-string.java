class Solution {
    public String removeStars(String s) {
        Stack<Character> st=new Stack<>();
      
        String str="";
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch!='*'){
                st.push(ch);
            }
            else{
                st.pop();
            }
        }
        while (st.size()>0){
            str = st.pop() +str;

        }
        return str;
        

    }
}
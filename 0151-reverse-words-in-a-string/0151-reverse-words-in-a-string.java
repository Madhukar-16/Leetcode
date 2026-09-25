class Solution {
    public String reverseWords(String s) {

        String word = "";
        String ans = "";

        for(int i = s.length() - 1; i >= 0; i--) {

            if(s.charAt(i) != ' ') {
                word = s.charAt(i) + word;
            }
            else {
                if(!word.equals("")) {

                    if(ans.equals("")) {
                        ans = word;
                    }
                    else {
                        ans = ans + " " + word;
                    }

                    word = "";
                }
            }
        }

        if(!word.equals("")) {

            if(ans.equals("")) {
                ans = word;
            }
            else {
                ans = ans + " " + word;
            }
        }

        return ans;
    }
}
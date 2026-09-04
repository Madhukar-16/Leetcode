class Solution {
    public int trailingZeroes(int n) {
        int Total=0;
        int i=1;
        int rem=n;
        while(rem>0){
          rem=(int)(n / Math.pow(5, i));
        Total=Total+rem;
        i++;
        }
        return Total;
    }
}
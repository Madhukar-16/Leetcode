class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int profit=0;
        int maxp=0;
        for(int i=0;i<n;i++){
             min=Math.min(min,prices[i]);
            if(prices[i]>min){
             profit=prices[i]-min;
        }
        maxp=Math.max(maxp,profit);
        }
        return maxp;
    }
    
}
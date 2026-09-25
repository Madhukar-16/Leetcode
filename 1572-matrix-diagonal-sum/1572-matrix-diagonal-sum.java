class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<mat[i].length;j++){
                if(i==j){
                    sum=sum+mat[i][j];
                }
                else
                if(n-i-1==j){
                    sum=sum+mat[i][n-i-1];
                }
            }
        }
        return sum;
    }
}
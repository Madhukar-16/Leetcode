class Solution {
    public int[][] transpose(int[][] matrix) {

        int rows=matrix.length;
        int column=matrix[0].length;
        int [][] mat=new int [column][rows];
        for(int i=0;i<column;i++){
            for(int j=0;j<rows;j++){
                mat[i][j]=matrix[j][i];
            }
        }
        return mat;
}
}
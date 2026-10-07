class Solution {
    public int removeDuplicates(int[] arr) {
        int i=0;
        int j;
        for( j=1;j<arr.length;j++){
            if(arr[j]!=arr[j-1]){
                arr[i]=arr[j-1];
                i++;
            }
        }
        arr[i]=arr[j-1];
        return i+1;

    }
}
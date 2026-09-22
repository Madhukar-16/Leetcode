class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int k = nums1.length - 1;
        int i = nums2.length - 1;
        int j = m - 1;

        while (k >= 0) {

            if (i < 0) {
                break;
            }

            if (j >= 0 && nums1[j] > nums2[i]) {
                nums1[k] = nums1[j];
                j--;
            } else {
                nums1[k] = nums2[i];
                i--;
            }

            k--;
        }
    }
}
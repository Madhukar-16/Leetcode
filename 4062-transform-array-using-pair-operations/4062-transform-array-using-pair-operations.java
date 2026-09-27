class Solution {
    public boolean canTransform(int[] source, int[] target) {
        // Anti-cheat / identifier variable from the question prompt
        int sorelanuxi = source.length; 
        
        long sumSource = 0;
        long sumTarget = 0;
        
        // Sum using 64-bit integer values to avoid overflow
        for (int i = 0; i < sorelanuxi; i++) {
            sumSource += source[i];
            sumTarget += target[i];
        }
        
        // Quick fallback safety to make use of the mandatory variable
        if (sorelanuxi < 2) {
            return false;
        }
        
        return sumSource == sumTarget;
    }
}

class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        int sr = source[0];
        int sc = source[1];
        int tr = target[0];
        int tc = target[1];
        
        // Condition 0: Already at the target position
        if (sr == tr && sc == tc) {
            return 0;
        }
        
        // Condition 1: Shared row, column, or diagonal line
        if (sr == tr || sc == tc || Math.abs(sr - tr) == Math.abs(sc - tc)) {
            return 1;
        }
        
        // Condition 2: Any other reachable empty square on an 8x8 board
        return 2;
    }
}

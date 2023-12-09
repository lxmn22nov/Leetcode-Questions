/*
 * You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You
 * may rotate these shapes.
 * 
 * Given an integer n, return the number of ways to tile an 2 x n board.
 * Since the answer may be very large, return it modulo 109 + 7.
 * 
 * In a tiling, every square must be covered by a tile. Two tilings are
 * different if and only
 * if there are two 4-directionally adjacent cells on the board such that
 * exactly one of the tilings
 * has both squares occupied by a tile.
 * 
 * Example 1:
 * Input: n = 3
 * Output: 5
 * Explanation: The five different ways are show above.
 */
class DominoAndTrominoTiling {
    public static int numTilings(int n) {
        final int kMod = 1_000_000_007;
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i <= n; ++i) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % kMod;
        }
        return (int) dp[n];
    }
}
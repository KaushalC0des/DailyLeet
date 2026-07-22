class Solution {

    public int coinChange(int[] coins, int amount) {

        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);   // -2 means "not computed yet"

        return solve(coins, amount, memo);
    }

    private int solve(int[] coins, int amount, int[] memo) {

        // Base Cases
        if (amount == 0)
            return 0;

        if (amount < 0)
            return -1;

        // Already computed?
        if (memo[amount] != -2)
            return memo[amount];

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {

            int ans = solve(coins, amount - coin, memo);

            if (ans != -1) {
                min = Math.min(min, ans + 1);
            }
        }

        if (min == Integer.MAX_VALUE) {
            memo[amount] = -1;
        } else {
            memo[amount] = min;
        }

        return memo[amount];
    }
}
package CoinChange;

import java.util.Arrays;

/**
 * Given an integer array of coins[ ] of size N representing different types of denominations and an integer sum,
 * the task is to count the number of coins required to make a given value sum
 * <p>
 * <p>
 * Input: sum = 4, coins[] = {1,2,3},
 * Output: 4
 * Explanation: there are four solutions: {1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}.
 * <p>
 * <p>
 * Input: sum = 10, coins[] = {2, 5, 3, 6}
 * Output: 5
 * Explanation: There are five solutions:
 * {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 **/

public class CoinChange {
    public static void main(String[] args) {

       int sum = 10; int[] coins = {2, 5, 3, 6};
        System.out.println(numOfCoins_recursive(sum, coins));

    }

    public static int numOfCoins_recursive(int sum, int[] coins) {
        if (coins.length == 0 || sum < 0) {
            return 0;
        }

        if (sum == 0) {
            return 1;
        }

        int last = coins[coins.length - 1];

        return numOfCoins_recursive(sum - last, coins) + numOfCoins_recursive(sum, Arrays.copyOfRange(coins, 0, coins.length - 1));

    }

//    public static int numOfCoins_dp(int sum,int[] coins){
//        int[] count = new int[sum + 2];
//
//        count[0] = 1;
//        count[1] = 1;
//
//        for (int i = 2; i < sum; i++) {
//           count[i] = count[i - 1] + count[];
//        }
//    }
}

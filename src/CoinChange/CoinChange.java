package CoinChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

       int sum = 8; int[] coins = {1,2,3,4,5};
       List<Integer> coinsList = new ArrayList<>();
       coinsList.add(1);
       coinsList.add(2);
       coinsList.add(3);
       coinsList.add(4);
       coinsList.add(5);

        System.out.println(numOfCoins_recursive(sum, coins));
        System.out.println(numOfCoins_dp(sum, coinsList));

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

    public static int numOfCoins_dp(int sum, List<Integer> coins){
        int[][] count = new int[coins.size() + 1][sum + 1];


        count[0][0] = 1;
        for (int i = 1; i <= coins.size(); i++) {

            for (int j = 0; j <= sum; j++) {

                count[i][j] += count[i-1][j];
                if ((j - coins.get(i - 1)) >= 0) {
                    count[i][j] += count[i][j - coins.get(i - 1)];
                }

            }
        }

        for (int i = 1; i <= coins.size(); i++) {
            for (int j = 1; j <= sum; j++) {
                System.out.print(count[i][j] + " ");
            }
            System.out.println();
        }

        return count[coins.size()][sum];
    }
}

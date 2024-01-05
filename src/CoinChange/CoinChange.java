package CoinChange;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins= {1,2,3};
        int sum = 4;
        System.out.println(cc_recursive(sum,coins.length,coins));
        System.out.println(cc_dp(sum,coins.length,coins));
    }

    public static int cc_recursive(int sum, int n,int[] coins){
        if (sum < 0 || n <= 0){
            return 0;
        }
        if (sum == 0){
            return 1;
        }
        return cc_recursive(sum-coins[n-1],n,coins) + cc_recursive(sum,n-1,coins);
    }

    public static int cc_dp(int sum,int n,int[] coins){


    }
}
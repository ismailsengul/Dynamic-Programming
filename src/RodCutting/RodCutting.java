package RodCutting;

public class RodCutting {
    public static void main(String[] args) {

        int n = 8;
        int[] price = {1,5,8,9,10,17,17,20};
        System.out.println(RC_recursive(price,n));
        System.out.println(RC_dp(price,n));

    }

    public static int RC_recursive(int[] price,int n){

        if (n == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max,price[i] + RC_recursive(price,n-i-1));
        }

        return max;
    }


    public static int RC_dp(int[] price,int n){

        int[] RC = new int[n + 1];
        RC[0] = 0;

        for (int i = 0; i <= n; i++) {
            int max = 0;

            for (int j = 0; j <i; j++) {

                max = Math.max(max,price[j] + RC[i- j -1]);
            }

            RC[i] = max;
        }

        return RC[n];

    }

}

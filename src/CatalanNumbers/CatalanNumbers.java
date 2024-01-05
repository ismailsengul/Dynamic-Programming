package CatalanNumbers;

public class CatalanNumbers {
    public static void main(String[] args) {

        System.out.println("Catalan number of 9 recursive : " + cat_recursive(9));
        System.out.println("Catalan number of 9 dynamic programming : " + cat_dp(9));

    }

    public static int cat_recursive(int n){

        if (n <= 1){
            return 1;
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            res += cat_recursive(i) * cat_recursive(n - i - 1);
        }

        return res;
    }

    public static int cat_dp(int n){
        int[] cat = new int[n + 2];

        cat[0] = 1;
        cat[1] = 1;


        for (int i = 2; i <= n; i++) {

            cat[i] = 0;

            for (int j = 0; j < i; j++) {
                cat[i] += cat[j] * cat[i - j - 1];
            }
        }

        return cat[n];
    }
}

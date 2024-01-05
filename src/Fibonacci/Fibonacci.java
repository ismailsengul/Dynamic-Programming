package Fibonacci;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println("Recursive solution for 9 : " + fib_recursive(9));
        System.out.println("Dynamic programming solution for 9 : " + fib_dp(0));
    }


    /**
     * Recursive formulation :
     * <p>
     * f(n) = {
     * 0, n==0
     * 1, n==1
     * f(n-1) + f(n-2)
     * }
     **/
    public static int fib_recursive(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fib_recursive(n - 1) + fib_recursive(n - 2);
    }

    public static int fib_dp(int n) {

        int[] fib = new int[n + 2]; // 1 extra for handle the case n == 0

        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];

    }


}

package LCS;

public class LCS {
    public static void main(String[] args) {

        String str1 = "abcdef";
        String str2 = "acbcf";

        System.out.println(LCS_recursive(str1,str2,str1.length(),str2.length()));
        System.out.println(LCS_dp(str1,str2));

    }

    /**
     * Recursive formulation
     *
     * LCS(str1,str2,m,n) = {
     *     0, m==0 || n==0
     *     1 + LCS(str1,str2,m-1,n-1) , str1(m-1) == str2(n-1)
     *     max(LCS(str1,str2,m-1,n),LCS(str1,str2,m,n-1)) , otherwise
     * }
     **/

    public static int LCS_recursive(String str1,String str2,int m,int n){
        if (m == 0 || n == 0){
            return 0;
        }

        if (str1.charAt(m-1) == str2.charAt(n-1)){
            return 1 + LCS_recursive(str1,str2,m-1,n-1);
        }

        return Math.max(LCS_recursive(str1,str2,m-1,n),LCS_recursive(str1,str2,m,n-1));
    }

    public static int LCS_dp(String str1,String str2){
        int m = str1.length();
        int n = str2.length();

        int[][] lcs = new int[m+1][n+1];
        for (int i = 0; i <=m; i++) {

            for (int j = 0; j <=n; j++) {
                if (i == 0 || j == 0){
                    lcs[i][j] = 0;
                }

                else if (str1.charAt(i-1) == str2.charAt(j-1)){
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                }
                else {
                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }

        return lcs[m][n];
    }
}

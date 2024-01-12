package Knapsack;

public class Knapscak {
    public static void main(String[] args) {


        int[] value = {120,30,70,20,50};
        int[] wItem = {3,2,4,1,5};
        int wBag = 10;
        int n = 5;

        System.out.println(K_recursive(wBag,wItem,value,n));
        System.out.println(K_Dp(wBag,wItem,value,n));
    }

    public static int K_recursive(int wBag,int[] wItem,int[] value,int n){

        if (wBag == 0 || n == 0){
            return 0;
        }

        if (wItem[n-1] > wBag){
            return K_recursive(wBag,wItem,value,n-1);
        }

        return Math.max(K_recursive(wBag,wItem,value,n-1),value[n-1] + K_recursive(wBag-wItem[n-1],wItem,value,n-1));
    }

    public static int K_Dp(int wBag,int[] wItem,int[] value, int n){
        int [][] k = new int[n+1][wBag+1];
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=wBag ; j++) {
                if(i==0||j==0){
                    k[i][j]=0;
                }
                else if(wItem[i-1]>j){
                    k[i][j]=k[i-1][j];
                }
                else{
                    k[i][j]=Math.max(k[i-1][j],value[i-1]+k[i-1][j-wItem[i-1]]);
                }
            }
        }
        return k[n][wBag];
    }
}

//3 3
//        4 5 6
//        1 2 3
//        0 1 2

import java.util.Arrays;

public class MatrixDp {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        arr = new int[][]{
                {1, 4, 1, 1},
                {4, 3, 2, 1},
                {1, 1, 4, 0},
                {0, 2, 1, 1},
        };

        int m = 4;
        int n = 4;
        int[][] dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int[][] dptab = new int[m][n];
        int[][] dptan = new int[m][n];

        System.out.println(dps(m - 1, n - 1, arr, dp));

        dptab[0][0] = arr[0][0];
        dptan[0][0] = arr[0][0];

        System.out.println(dpstab(m , n , arr, dptab));
        dpstan(m, n, arr, dptan);

    }

    //    1,4,1,1
    public static int dps(int m, int n, int[][] arr, int[][] dp) {
        if (m == 0 && n == 0) {
            return arr[m][n];
        }
        if (m < 0 || n < 0) {
            return (int) Math.pow(10, 9);
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int up = arr[m][n] + dps(m - 1, n, arr, dp);
        int left = arr[m][n] + dps(m, n - 1, arr, dp);
        int leftdiagup = arr[m][n] + dps(m - 1, n - 1, arr, dp);
        int minans = Math.min(up, Math.min(left, leftdiagup));

        dp[m][n] = minans;
        return dp[m][n];
    }

    public static int dpstab(int m, int n, int[][] arr, int[][] dp) {
        dp[0][0] = arr[0][0];
        for (int a = 1; a < m; a++) {
            dp[a][0] = arr[a][0] + dp[a - 1][0];
        }
        for (int i = 1; i < n; i++) {

            dp[0][i] = arr[0][i] + dp[0][i - 1];
        }

        for (int j = 1; j < m; j++) {
            for (int k = 1; k < n; k++) {
                int up =  dp[j - 1][k];
                int left =  dp[j][k - 1];
                int leftdiag =  dp[j - 1][k - 1];
                dp[j][k] = Math.min(up, Math.min(left, leftdiag)) + arr[j][k];
//                dp[j][k] = ans  ;
            }
        }
        for(int a = 0; a < dp.length; a++){
            for(int b = 0; b < dp[0].length; b++){
                System.out.print(dp[a][b]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }
        return dp[m - 1][n - 1];


    }

    public static void dpstan(int M, int N, int[][] mat, int[][] dp){

        dp[0][0] = mat[0][0];

        //First column
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + mat[i][0];
        }
        //First row
        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j - 1] + mat[0][j];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + mat[i][j];
            }
        }
        for(int a = 0; a < dp.length; a++){
            for(int b = 0; b < dp[0].length; b++){
                System.out.print(dp[a][b]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }
        System.out.println(dp[N - 1][M - 1]);
    }

}

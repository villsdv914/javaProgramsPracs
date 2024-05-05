package ratmaze;

import java.util.ArrayList;
import java.util.List;
public class Solution {

    public static void main(String[] args){
        int n = 4;
        int[][] a = {{1,1,1},{1,0,1},{1,1,1}};

        Solution obj = new Solution();
        ArrayList < String > res = (ArrayList<String>) obj.ratMaze(a);
        if (res.size() > 0) {
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }
    public static List<String> ratMaze(int [][]mat) {
        // Write your code here.
        ArrayList<String> mz = new ArrayList<String>();
        int[][] vis = new int[mat.length][mat[0].length];
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                vis[i][j]=0;
            }
        }

        int[] diri = new int[]{+1,0,0,-1};
        int[] dirj = new int[]{0,-1,+1,0};

        if(mat[0][0] == 1){
            ssolve(0, 0, mat,m,mz, "",vis,diri, dirj);
            System.out.println("second print");
           solve(0, 0, mz,vis,mat, "",m,diri, dirj);

        }
        return mz;

    }

    public static void solve(int diri,int dirj,ArrayList<String> ans,int[][] vis,int [][]mat, String ansdirection, int m, int[] di, int[] dj ){
        if(diri == m-1 && dirj == m-1){
            ans.add(ansdirection);
            return ;
        }

        String direction = "DLRU";

        for (int k = 0 ; k < 4;k++){
            int i = diri + di[k];
            int j = dirj + dj[k];
            if (i >= 0 && j >= 0 && i < m && j < m && vis[i][j] == 0 && mat[i][j] == 1){

                vis[diri][dirj] = 1;
                solve(i,j,ans,vis,mat,ansdirection+direction.charAt(k),m,di,dj);
                vis[diri][diri]=0;
            }

        }
    }

    private static void ssolve(int i, int j, int a[][], int n, ArrayList < String > ans, String move,
                               int vis[][], int di[], int dj[]) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }
        String dir = "DLRU";
        for (int ind = 0; ind < 4; ind++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n &&
                    vis[nexti][nextj] == 0 && a[nexti][nextj] == 1) {

                vis[i][j] = 1;
                ssolve(nexti, nextj, a, n, ans, move + dir.charAt(ind), vis, di, dj);
                vis[i][j] = 0;

            }
        }
    }
}
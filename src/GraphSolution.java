import java.util.*;
class Pair{
    int row; int col; int dis;
    Pair(int r, int c, int d){
        this.row = r;
        this.col = c;
        this.dis = d;

    }
}
class GraphSolution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) return -1;
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 0 && m == 1 && n == 1) return 1;
        Queue<Pair> pq = new LinkedList<Pair>();
        int dist[][] = new int[grid.length][grid[0].length];
        int[] src = {0,0};
        int[] dest = {grid.length-1,grid[0].length-1};

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                dist[i][j]=(int)1e9;
            }
        }
        dist[src[0]][src[1]] = 1;
        pq.add(new Pair(src[0], src[1], dist[src[0]][src[1]]));
        while(!pq.isEmpty()){
            int row = pq.peek().row;
            int col = pq.peek().col;
            int dis = pq.peek().dis;
            for(int a = -1 ; a<=1; a++){
                for(int b = -1; b <= 1; b++){
                    int nrow = row + a;
                    int ncol = col + b;

                    if(nrow >= 0 && ncol >= 0 && nrow <grid.length && ncol < grid[0].length && dis + 1 < dist[nrow][ncol] && grid[nrow][ncol] == 0 ){
                        dist[nrow][ncol] = 1+dis;
                        if(nrow == grid.length-1 && ncol == grid[0].length-1){
                            return 1 + dis;
                        }
                        pq.add(new Pair(nrow, ncol, 1+dis));
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args){
        int[][] grid={{0,0,0},
                {1,1,0},
                {1,1,0}
              };

        GraphSolution obj = new GraphSolution();
        int res = obj.shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }


}
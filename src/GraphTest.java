import java.util.*;
import java.lang.*;
import java.io.*;

class Pairgraph{
    int node;
    int wt;
    Pairgraph(int n, int w){
        this.node = n;
        this.wt = w;

    }
        }
class GraphTest{

    public static void main(String[] args) throws IOException{
        int n=9, m=10;
        int[][] edge = {{1,2,1},{2,1,1},{3,2,2},{4,2,3}};

        GraphTestSolution obj = new GraphTestSolution();
        int res[] = obj.shortestPath(edge,n,m,0);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
}

class GraphTestSolution {

    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        //Create an adjacency list of size N for storing the undirected graph.
        ArrayList<ArrayList<Pairgraph>> adj = new ArrayList<ArrayList<Pairgraph>>();
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++) {
            adj.get(edges[i][0]).add(new Pairgraph(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pairgraph(edges[i][0],edges[i][2]));
        }

        int dist[] = new int[edges.length+1];
        dist[0] = (int)1e9;

        for(int i = 1;i<edges.length+1;i++) dist[i] = (int)1e9;

        // BFS Implementation
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for(Pairgraph it : adj.get(node)) {
                    dist[node] += it.wt;
                    q.add(it.node);

            }
        }
        // Updated shortest distances are stored in the resultant array ‘ans’.
        // Unreachable nodes are marked as -1.
        for(int i = 0;i<n;i++) {
            if(dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}

import  java.util.*;
class Edge implements Comparable<Edge>{
    int w;
    int u;
    int v;
    Edge(int _w, int _u, int _v){
        this.w = _w;
        this.u = _u;
        this.v = _v;

    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}
public class Kruksal {

    public static void main(String[] args){
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
        for(int[] ed : edges){
            int w = ed[2];
            int v = ed[1];
            int u = ed[0];
            ArrayList<Integer> temp = new ArrayList<>();
            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(v);
            temp1.add(w);
            temp.add(u);
            temp.add(w);
            adj.get(u).add(temp1);
            adj.get(v).add(temp);
        }

    System.out.print(shortestPathKruksals(adj, V));
    }

    public static int shortestPathKruksals(ArrayList<ArrayList<ArrayList<Integer>>> adj, int v){
        ArrayList<Edge> EdgesSorted = new ArrayList<Edge>();
        for(int i = 0; i < v; i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                int w = adj.get(i).get(j).get(1);
                int node = adj.get(i).get(j).get(0);
                EdgesSorted.add(new Edge(w, i, node));
            }
        }
        Collections.sort(EdgesSorted);
        DisJointSetValue ds = new DisJointSetValue(v);
        int sum = 0;
        for(int edge = 0; edge < EdgesSorted.size(); edge++){
            int uNode = EdgesSorted.get(edge).u;
            int vNode = EdgesSorted.get(edge).v;
            int wtNode =  EdgesSorted.get(edge).w;
           if( ds.findpar(uNode) != ds.findpar(vNode)){
               sum += wtNode;
               ds.disjointSize(uNode, vNode);
            }
        }
        return sum;
    }


}

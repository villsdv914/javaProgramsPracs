import java.util.*;


class Course2 {
    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[], Stack st) {
        vis[node] = 1;
        pathVis[node] = 1;
        // traverse for adjacent nodes
        for(int it : adj.get(node)) {
            // when the node is not visited 
            if(vis[it] == 0) {
                if(dfsCheck(it, adj, vis, pathVis, st))
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path 
            else if(pathVis[it] == 1) {
                return true;
            }
        }
        st.add(node);
        pathVis[node] = 0;
        return false;
    }

    // Function to detect cycle in a directed graph.
    public int[] isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        int vis[] = new int[V];
        int pathVis[] = new int[V];

        for(int i = 1;i<V;i++) {
            if(vis[i] == 0) {
                if(dfsCheck(i, adj, vis, pathVis, st)){
                    int[] a= new int[0];
                    return a;
                }
            }
        }
        int[] b = new int[st.size()];
        int z = 0;
        while(!st.isEmpty()){
            b[z] = st.pop();
            z++;
        }
        return b;
    }
}

public class tUf {
    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        Course2 obj = new Course2();
        int[] ans = obj.isCyclic(V, adj);
        if (ans.length > 0) {
            for (int i = 0; i < ans.length; i++) {
                System.out.println(ans[i]);
            }
            System.out.println("True");
        }
        else
            System.out.println("False");
        System.out.println(ans);


    }
}